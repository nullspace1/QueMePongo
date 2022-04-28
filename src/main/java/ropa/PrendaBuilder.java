package ropa;

public class PrendaBuilder {

  private Prenda prenda;

  public PrendaBuilder(TipoPrenda tipoPrenda) {
    prenda = new Prenda(tipoPrenda);
  }

  // Esto se siento un poco como un pasamanos...
  // Estas retornan un PrendaBuilder para poder hacer muchas llamadas en una linea.
  public PrendaBuilder fijarColorPrimario(Color color) {
    prenda.setColorPrimario(color);
    return this;
  }

  public PrendaBuilder fijarColorSecundario(Color color) {
    prenda.setColorSecundario(color);
    return this;
  }

  public PrendaBuilder fijarComposicion(Composicion composicion) {
    prenda.setComposicion(composicion);
    return this;
  }

  public PrendaBuilder fijarTrama(Trama trama) {
    prenda.setTrama(trama);
    return this;

  }


  public Prenda build() {
    if (prenda.esPrendaValida()) {
      return prenda;
    } else {
      throw new PrendaInvalidaException(
          "No se puede construir la prenda, tiene componentes faltantes!");
    }
  }



}
