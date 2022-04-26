package ropa;

public class PrendaBuilder {

  private Prenda prenda;

  public PrendaBuilder(TipoPrenda tipoPrenda) {
    prenda = new Prenda(tipoPrenda);
  }

  // Esto se siento un poco como un pasamanos...
  public void fijarColorPrimario(Color color) {
    prenda.setColorPrimario(color);
  }

  public void fijarColorSecundario(Color color) {
    prenda.setColorSecundario(color);
  }

  public void fijarComposicion(Composicion composicion) {
    prenda.setComposicion(composicion);
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
