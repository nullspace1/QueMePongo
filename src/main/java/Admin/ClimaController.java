package Admin;

import clima.Alerta;
import clima.Clima;
import clima.ProveedorClima;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ClimaController {

  private static final ClimaController INSTANCE = new ClimaController();
  private UserEvents userEvents;
  private ProveedorClima proveedorClima;
  private List<Alerta> alertasMasRecientes = new ArrayList<>();

  public static ClimaController getInstance() {
    return INSTANCE;
  }

  public Clima getClima() {
    return proveedorClima.getWeather("Buenos Aires, Argentina");
  }

  public void actualizarAlertas() {
    List<Alerta> alertasActualizadas = proveedorClima.getAlertas("Buenos Aires,Argentina");
    if (cambiaronLasAlertas(alertasActualizadas)) {
      alertasMasRecientes = alertasActualizadas;
      userEvents.notificarUsuarios(alertasMasRecientes);
    }
  }

  public List<Alerta> getAlertasMasRecientes() {
    return alertasMasRecientes;
  }

  public void setProveedorClima(ProveedorClima proveedorClima) {
    this.proveedorClima = proveedorClima;
  }

  public void setUserController(UserEvents userEvents){
    this.userEvents = userEvents;
  }


  private boolean cambiaronLasAlertas(List<Alerta> alertasActualizadas) {
    return !(new HashSet<>(alertasActualizadas).containsAll(alertasMasRecientes) && new HashSet<>(
        alertasMasRecientes).containsAll(alertasActualizadas));
  }


}
