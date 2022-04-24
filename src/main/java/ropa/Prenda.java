package ropa;

public class Prenda {

  private TipoPrenda tipo;
  private Composicion composicion;
  private Trama trama;
  private Color colorPrimario;
  private Color colorSecundario;

  public Prenda(TipoPrenda tipo) {

    this.tipo = tipo;
    this.trama = Trama.LISA;
    this.composicion = null;
    this.colorPrimario = null;

  }

  /*
   * No me gusta tener un getter solo para testear, pero por el momento no se me ocurre otra manera.
   * Aca el problema creo que es que la trama de una prenda no hace "nada" y entonces no tengo
   * manera de testear por algun metodo publico.
   */

  public Trama getTrama() {
    return this.trama;
  }

  // Algun tipo de logica para verificar contra el tipo en estos...?

  public void setColorPrimario(Color color) {

    this.colorPrimario = color;
  }

  public void setColorSecundario(Color color) {
    this.colorSecundario = color;
  }

  public boolean esPrendaValida() {
    return (this.tipo != null && this.composicion != null && this.colorPrimario != null);
  }

  public void setComposicion(Composicion composicion) {
    this.composicion = composicion;
  }



}
