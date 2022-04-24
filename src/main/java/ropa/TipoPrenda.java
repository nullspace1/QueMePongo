package ropa;

public class TipoPrenda {

  private Categoria categoria;

  private TipoPrenda(Categoria categoria) {
    this.categoria = categoria;
  }

  public Categoria getCategoria() {
    return this.categoria;
  }

  // Podria pertenecer una prenda de un tipo a mas de una categoria...?
  public static final TipoPrenda ZAPATOS = new TipoPrenda(Categoria.CALZADO);
  public static final TipoPrenda CAMISA = new TipoPrenda(Categoria.PARTE_SUPERIOR);
}
