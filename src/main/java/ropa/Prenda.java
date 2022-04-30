package ropa;

public class Prenda {

  private TipoPrenda tipo;
  private Composicion composicion;
  private Trama trama;
  private Color colorPrimario;
  private Color colorSecundario;


  public Prenda(TipoPrenda tipo, Color colorPrimario, Color colorSecundario,
      Composicion composicion, Trama trama) {
    this.tipo = tipo;
    this.colorPrimario = colorPrimario;
    this.colorSecundario = colorSecundario;
    this.composicion = composicion;
    this.trama = trama;
  }

  public Trama getTrama() {
    return this.trama;
  }

  public boolean esPrendaValida() {
    return (this.tipo != null && this.composicion != null && this.colorPrimario != null);
  }

  public boolean tieneCategoria(Categoria parteSuperior) {
    return (this.tipo.getCategoria() == parteSuperior);
  }



}
