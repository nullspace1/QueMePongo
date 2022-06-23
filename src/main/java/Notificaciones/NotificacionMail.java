package Notificaciones;

import Admin.MailService;
import clima.Alerta;
import java.util.List;
import ropa.Usuario;

public class NotificacionMail implements AlertaObserver{

  private MailService mailService;

  public NotificacionMail(MailService mailService){
    this.mailService = mailService;
  }

  public String generarLista(List<Alerta> alertas){
    final String[] alertasDetectadas = {""};
    alertas.forEach(alerta -> {
      alertasDetectadas[0] = alertasDetectadas[0].concat(" " + alerta.name());});
    return alertasDetectadas[0];
  }

  @Override
  public void observe(Usuario usuario, List<Alerta> alertas) {
    mailService.send(usuario.getMail(), generarLista(alertas));
  }
}
