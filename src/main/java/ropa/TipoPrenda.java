package ropa;

public class TipoPrenda {

  private Categoria categoria;

  public TipoPrenda(Categoria categoria) {
    this.categoria = categoria;
  }

  public Categoria getCategoria() {
    return this.categoria;
  }

  // Podria pertenecer una prenda de un tipo a mas de una categoria...?
  public TipoPrenda zapatos = new TipoPrenda(Categoria.CALZADO);
  public TipoPrenda camisa = new TipoPrenda(Categoria.PARTE_SUPERIOR);
}
