package ropa;

/**
 * 
 */
public abstract class Propuesta {


    public Propuesta(Prenda prenda) {
        this.prenda = prenda;
    }

    protected Prenda prenda;
    protected Guardaropa guardaropa;

    public abstract void aceptar();

    public void rechazar(){
        guardaropa.getPropuestasPendientes().remove(this);
    }

    public abstract void deshacer();

    public void setGuardaropa(Guardaropa guardaropa) {
        this.guardaropa = guardaropa;
    }


}
