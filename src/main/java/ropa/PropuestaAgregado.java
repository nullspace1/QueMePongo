package ropa;

import ropa.Propuesta;

import java.util.*;

/**
 * 
 */
public class PropuestaAgregado extends Propuesta {


    public PropuestaAgregado(Prenda prenda) {
        super(prenda);
    }

    @Override
    public void aceptar() {
        guardaropa.add(this.prenda);
        guardaropa.getPropuestasPendientes().remove(this);
        guardaropa.getPropuestasAceptadas().add(this);
    }

    @Override
    public void deshacer() {
        guardaropa.remove(this.prenda);

    }
}