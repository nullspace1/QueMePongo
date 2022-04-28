package prototype;

import ropa.Categoria;
import ropa.Prenda;

public class Uniforme {

  private Prenda prendaSuperior;
  private Prenda prendaInferior;
  private Prenda calzado;
  private String institucion;

  public Uniforme(Prenda prendaSuperior, Prenda prendaInferior, Prenda calzado,
      String institucion) {
    if (!verificarCategorias(prendaSuperior, prendaInferior, calzado)) {
      throw new UniformeInvalidoException("Uniforme contiene prendas del tipo equivocado!");
    }
    this.calzado = calzado;
    this.prendaInferior = prendaInferior;
    this.prendaSuperior = prendaSuperior;
    this.institucion = institucion;
  }

  private boolean verificarCategorias(Prenda prendaSuperior, Prenda prendaInferior,
      Prenda calzado) {
    return (prendaSuperior.tieneCategoria(Categoria.PARTE_SUPERIOR)
        && prendaInferior.tieneCategoria(Categoria.PARTE_INFERIOR)
        && calzado.tieneCategoria(Categoria.CALZADO));
  }

  public String getInstitucion() {
    return this.institucion;
  }

}
