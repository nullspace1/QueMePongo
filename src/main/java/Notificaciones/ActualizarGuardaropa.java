package Notificaciones;

import clima.Alerta;
import java.util.List;
import ropa.Usuario;

public class ActualizarGuardaropa implements AlertaObserver{

  @Override
  public void observe(Usuario usuario, List<Alerta> alertaList) {
    usuario.generarSugerenciaDiaria();
  }
}
