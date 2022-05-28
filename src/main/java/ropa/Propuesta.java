package ropa;

import java.util.*;

/**
 * 
 */
public abstract class Propuesta {


    public Propuesta(Prenda prenda) {
        this.prenda = prenda;
    }

    protected Prenda prenda;
    protected Guardaropa guardaropa;

    public abstract void hacer(Usuario permitido);

    public abstract void deshacer(Usuario permitido);

    public void setGuardaropa(Guardaropa guardaropa) {
        this.guardaropa = guardaropa;
    }
}