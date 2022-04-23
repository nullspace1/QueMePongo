package ropa;

public class Prenda {

  private TipoPrenda tipo;
  private Composicion composicion;
  private Color colorPrimario;
  private Color colorSecundario;

  public Prenda(TipoPrenda tipo, Categoria categoria, Composicion composicion, Color colorPrimario,
      Color colorSecundario) {
    if (tieneComponentesImportantesNulos(tipo, composicion, categoria, colorPrimario)) {
      throw new MissingComponentException("Algun/os componentes de la ropa no existen!");
    }

    this.tipo = tipo;
    this.composicion = composicion;
    this.colorPrimario = colorPrimario;
    this.colorSecundario = colorSecundario;

  }

  private boolean tieneComponentesImportantesNulos(TipoPrenda tipo, Composicion composicion,
      Categoria categoria, Color colorPrimario) {

    return (tipo == null || composicion == null || categoria == null || colorPrimario == null);
  }

}
