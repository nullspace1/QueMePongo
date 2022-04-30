package ropa;

public class Borrador {

  private TipoPrenda tipo;
  private Composicion composicion;
  private Trama trama;
  private Color colorPrimario;
  private Color colorSecundario;

  public Borrador(Trama tramaDefault) {
    this.trama = tramaDefault;
  }

  public Borrador fijarTipo(TipoPrenda tipo) {
    this.tipo = tipo;
    return this;
  }


  public Borrador fijarColorPrimario(Color color) {
    this.colorPrimario = color;
    return this;
  }

  public Borrador fijarColorSecundario(Color color) {
    this.colorSecundario = color;
    return this;
  }

  public Borrador fijarComposicion(Composicion composicion) {
    this.composicion = composicion;
    return this;
  }

  public Borrador fijarTrama(Trama trama) {
    this.trama = trama;
    return this;

  }

  public boolean esPrendaValida() {
    return (this.tipo != null && this.composicion != null && this.colorPrimario != null);
  }


  public Prenda build() {
    if (esPrendaValida()) {
      return new Prenda(this.tipo, this.colorPrimario, this.colorSecundario, this.composicion,
          this.trama);
    } else {
      throw new PrendaInvalidaException(
          "No se puede construir la prenda, tiene componentes faltantes!");
    }
  }



}
