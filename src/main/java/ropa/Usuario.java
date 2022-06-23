package ropa;

import Admin.NoExisteAtuendoException;
import Notificaciones.AlertaObserver;
import clima.Alerta;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 *
 */
public class Usuario {

  private final Set<Guardaropa> guardaropas = new HashSet<>();
  public List<AlertaObserver> accionDeAlertas = new ArrayList<>();
  private Atuendo sugerenciaDiaria = null;

  private final String mail;

  public Usuario(String mail){
    this.mail = mail; // todo matchear al regex de un mail
  }

  public Set<Guardaropa> getGuardaropas() {
    return guardaropas;
  }

  public Guardaropa getGuaradaropasCon(String nombre) {
    Optional<Guardaropa> guardaropaOptional = guardaropas.stream()
        .filter(guardaropa -> Objects.equals(
            guardaropa.nombre, nombre)).findAny();
    if (guardaropaOptional.isPresent()) {
      return guardaropaOptional.get();
    } else {
      throw new NoExisteGuaradaropaException("No se posee un guardaropas con ese nombre!");
    }
  }

  public Atuendo getSugerenciaDiaria() {
    if (sugerenciaDiaria == null) {
      throw new NoExisteAtuendoException("No hay una sugerencia diaria definida aun!");
    } else {
      return sugerenciaDiaria;
    }
  }

  public void generarSugerenciaDiaria() {
    if (!guardaropas.isEmpty()) {
      Guardaropa guardaropa = guardaropas.stream().findAny().get();
      sugerenciaDiaria = guardaropa.getSugerencia();
    }
  }

  public void agregarGuardaropas(Guardaropa guardaropa) {
    guardaropas.add(guardaropa);
  }

  public void recibirNotificacion(List<Alerta> alertas) {
    accionDeAlertas.forEach(accion -> accion.observe(this, alertas));
  }

  public void agregarAccion(AlertaObserver accionDeAlerta) {
    accionDeAlertas.add(accionDeAlerta);
  }

  public void quitarAccion(AlertaObserver accionDeAlerta) {
    accionDeAlertas.remove(accionDeAlerta);
  }

  public String getMail() {
    return mail;
  }
}
