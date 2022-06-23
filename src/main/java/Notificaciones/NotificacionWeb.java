package Notificaciones;

import Admin.NotificationService;
import clima.Alerta;
import java.util.List;
import ropa.Usuario;

public class NotificacionWeb implements AlertaObserver {

  private final Alerta alertaANotificar;
  private final NotificationService notificationService;

  public NotificacionWeb(Alerta alertaANotificar,NotificationService notificationService){
    this.alertaANotificar = alertaANotificar;
    this.notificationService = notificationService;
  }

  @Override
  public void observe(Usuario usuario, List<Alerta> alertas) {
  if (alertas.contains(alertaANotificar)){
   notificationService.notify(alertaANotificar.mensaje());
  }
  }
}
