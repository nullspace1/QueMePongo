package ropa;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Atuendo {

    Map<Categoria,Prenda> sugerenciasDelAtuendo = new HashMap<Categoria, Prenda>();

    public void agregarPrenda(Prenda prenda) {
        sugerenciasDelAtuendo.put(prenda.getCategoria(),prenda);
    }

    public Prenda getDeCategoria(Categoria categoria){
        if (noHayDeCategoria(categoria)) throw new NoHayDeCategoriaException("No hay prendas de esa categoria en el atuendo!");
        return sugerenciasDelAtuendo.get(categoria);
    }

    private boolean noHayDeCategoria(Categoria categoria) {
        return !sugerenciasDelAtuendo.keySet().contains(categoria);
    }
}
