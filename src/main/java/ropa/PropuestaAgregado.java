package ropa;

import ropa.Propuesta;

import java.util.*;

/**
 * 
 */
public class PropuestaAgregado extends Propuesta {


    public PropuestaAgregado(Guardaropa guardaropa, Prenda prenda) {
        super(prenda);
    }

    @Override
    public void hacer (Usuario usuarioPermitido) {
        guardaropa.add(this.prenda,usuarioPermitido);
    }

    @Override
    public void deshacer(Usuario usuarioPermitido) {
        guardaropa.remove(this.prenda,usuarioPermitido);
    }
}