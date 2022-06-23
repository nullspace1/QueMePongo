package Notificaciones;

import clima.Alerta;

import java.util.List;
import ropa.Usuario;

public interface AlertaObserver {

  public void observe(Usuario usuario, List<Alerta> alertas);

}
