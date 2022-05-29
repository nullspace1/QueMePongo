package ropa;

import ropa.Guardaropa;
import ropa.Prenda;
import ropa.Propuesta;
import java.util.*;


public class PropuestaQuitado extends Propuesta {


    public PropuestaQuitado(Prenda prenda) {
        super(prenda);
    }

    @Override
    public void aceptar() {
        guardaropa.remove(this.prenda);
    }

    @Override
    public void deshacer() {
        guardaropa.add(this.prenda);
    }

}