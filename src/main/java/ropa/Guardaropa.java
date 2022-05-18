package ropa;

import clima.Clima;

import java.security.Guard;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Guardaropa {

    private Map<Categoria,List<Prenda>> prendasDisponibles  = new HashMap<>();
    public Guardaropa filtrarPrendasAcorde(Clima climaActual) {
        Map<Categoria,List<Prenda>> prendasAcordeClima = new HashMap<>(prendasDisponibles).entrySet().stream().collect(Collectors.toMap(entrada -> entrada.getKey(),valor ->  valor.getValue().stream().filter(prenda -> prenda.satisfaceCondicionesDe(climaActual)).collect(Collectors.toList())));
        return new Guardaropa(prendasAcordeClima);
    }

    public Prenda getOf(Categoria categoria) {
        return prendasDisponibles.get(categoria).stream().findAny().get();
    }

    private Guardaropa(Map<Categoria,List<Prenda>> prendasDisponibles){
        this.prendasDisponibles = prendasDisponibles;
    }
}
