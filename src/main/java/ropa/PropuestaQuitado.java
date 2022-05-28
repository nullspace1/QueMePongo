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
    public void hacer(Usuario usuario) {
        guardaropa.remove(this.prenda,usuario);
    }

    @Override
    public void deshacer(Usuario usuario) {
        guardaropa.add(this.prenda,usuario);
    }

}