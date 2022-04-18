package ropa;

public class Prenda {
	
	private Tipo tipo;
	private Categoria categoria;
	private Composicion composicion;
	private Color colorPrimario;
	private Color colorSecundario;

	public Prenda(Tipo tipo, Categoria categoria, Composicion composicion, Color colorPrimario, Color colorSecundario) throws MismatchException, MissingComponentException
	{
		if (tieneComponentesImportantesNulos(tipo,composicion,categoria,colorPrimario))
		{
			throw new MissingComponentException("Algun/os componentes de la ropa no existen!");
		}
		
		if (!categoria.pertenece(tipo))
		{
			throw new MismatchException("El tipo no corresponde con su categoria!");
		}
		
		this.tipo = tipo;
		this.categoria = categoria;
		this.composicion = composicion;
		this.colorPrimario = colorPrimario;
		this.colorSecundario = colorSecundario;
		
	}

	private boolean tieneComponentesImportantesNulos(Tipo tipo, Composicion composicion, Categoria categoria, Color colorPrimario) {
		
		return (tipo == null || composicion == null || categoria == null || colorPrimario == null);
	}
	
}
 