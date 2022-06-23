package clima;

import Admin.NotificationService;

public enum Alerta {
  TORMENTA("Se viene tormenta, llevar paraguas!"),
  GRANIZO("Se viene granizo, no viajes en auto!");


  private String mensaje;

  Alerta(String mensaje){
    this.mensaje = mensaje;
  }

  public String mensaje() {
    return this.mensaje;
  }
}
