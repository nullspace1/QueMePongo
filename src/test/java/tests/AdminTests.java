package tests;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import Admin.ClimaController;
import Admin.DataProvider;
import Admin.MailService;
import Admin.NotificationService;
import Admin.UserContainer;
import Notificaciones.ActualizarGuardaropa;
import Notificaciones.AlertaObserver;
import Notificaciones.NotificacionMail;
import Notificaciones.NotificacionWeb;
import clima.Alerta;
import clima.Clima;
import clima.ProveedorClima;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ropa.Borrador;
import ropa.Color;
import ropa.Composicion;
import ropa.Guardaropa;
import ropa.Prenda;
import ropa.TipoPrenda;
import ropa.Trama;
import ropa.Usuario;

public class AdminTests {

  private static MailService mailService;
  private static  DataProvider dataProvider;
  private static NotificationService notificationService;

  private static ProveedorClima climaProvider;



  @BeforeAll
  public static void setUp(){
    mailService = mock(MailService.class);
    dataProvider = mock(DataProvider.class);
    notificationService = mock(NotificationService.class);
    climaProvider = mock(ProveedorClima.class);
    ClimaController.getInstance().setProveedorClima(climaProvider);
    ClimaController.getInstance().setUserController(new UserContainer(dataProvider));
    when(climaProvider.getWeather(anyString())).thenReturn(new Clima(0.3,999));
  }

  @Test
  public void generarSugerenciasUsuarios() {
    Usuario usuario = getUsuario();
    usuario.generarSugerenciaDiaria();
    Assertions.assertNotNull(usuario.getSugerenciaDiaria());
  }

  @Test
  public void dispararCalculoDeSugerencias(){
    Usuario usuario = mock(Usuario.class);
    UserContainer userContainer = new UserContainer(dataProvider);
    when(dataProvider.getDataFrom(anyString())).thenReturn(new ArrayList<>(
        Collections.singletonList(usuario)));
    userContainer.generarNuevasSugerencias();
    verify(usuario).generarSugerenciaDiaria();
  }

  @Test
  public void conocerUltimasAlertasMetereologicas(){
    when(climaProvider.getAlertas(anyString())).thenReturn(new ArrayList<>(Collections.singletonList(
        Alerta.TORMENTA)));
    when(dataProvider.getDataFrom(anyString())).thenReturn(
        new ArrayList<>());
    ClimaController.getInstance().actualizarAlertas();
    Assertions.assertTrue(ClimaController.getInstance().getAlertasMasRecientes().contains(Alerta.TORMENTA));
  }

  @Test
  public void notificacionesSeDisparan(){
    Usuario usuario = getUsuario();


    AlertaObserver notificarPorWeb = new NotificacionWeb(Alerta.TORMENTA,notificationService);
    AlertaObserver notificarMail = new NotificacionMail(mailService);
    AlertaObserver actualizarGuardaropa = new ActualizarGuardaropa();
    usuario.agregarAccion(notificarMail);
    usuario.agregarAccion(notificarPorWeb);
    usuario.agregarAccion(actualizarGuardaropa);

    when(dataProvider.getDataFrom(anyString())).thenReturn(new ArrayList<>(Collections.singletonList(usuario)));
    when(climaProvider.getAlertas(anyString())).thenReturn(new ArrayList<>(Collections.singletonList(
        Alerta.TORMENTA)));

    ClimaController.getInstance().actualizarAlertas();

    verify(mailService).send(anyString(),anyString());
    verify(notificationService).notify(anyString());
    Assertions.assertNotNull(usuario.getSugerenciaDiaria());
  }

  private Usuario getUsuario(){
    Usuario usuario = new Usuario("test@mail.com");
    Guardaropa guardaropa = new Guardaropa("Test",usuario);
    guardaropa.add(getPrenda());
    usuario.agregarGuardaropas(guardaropa);
    return usuario;
  }

  private Prenda getPrenda(){
    return new Borrador(Trama.RAYADA).fijarComposicion(Composicion.CUERO).fijarTipo(TipoPrenda.CAMISA).fijarColorPrimario(
        Color.ROJO).fijarTemperaturaMaxima(9999).build();
  }

}
