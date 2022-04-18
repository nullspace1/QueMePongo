package ropa;

import java.util.List;

public class Categoria {
	
	List<Tipo> tiposDeLaCategoria;
	
	public Categoria(List<Tipo> tiposDeLaCategoria)
	{
		this.tiposDeLaCategoria = tiposDeLaCategoria;
	}

	public boolean pertenece(Tipo tipo) {
		return tiposDeLaCategoria.contains(tipo);
	}

}
