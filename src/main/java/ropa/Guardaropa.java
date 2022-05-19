package ropa;

import clima.Clima;
import clima.InformanteClima;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Guardaropa {

    private Map<Categoria,List<Prenda>> prendasDisponibles  = new HashMap<>();

    public Atuendo getSugerencia(){
        Clima climaActual = InformanteClima.getInstance().obtenerClimaEnBuenosAires();
        Guardaropa guardaropaAcordeAlClima = this.filtrarPrendasAcorde(climaActual);
        return tomarAtuendosDe(guardaropaAcordeAlClima);
    }

    private Atuendo tomarAtuendosDe(Guardaropa guardaropaAcordeAlClima) {
        Atuendo atuendo = new Atuendo();
        guardaropaAcordeAlClima.prendasDisponibles.forEach((k,v) -> atuendo.agregarPrenda(v.stream().findAny().get()));
        return atuendo;
    }

    public void add(Prenda prenda){
        prendasDisponibles.putIfAbsent(prenda.getCategoria(), new ArrayList<>());
        List<Prenda> lista = prendasDisponibles.get(prenda.getCategoria());
        lista.add(prenda);
       prendasDisponibles.put(prenda.getCategoria(), lista);
    }

    private Guardaropa(Map<Categoria,List<Prenda>> prendasDisponibles){
        this.prendasDisponibles = prendasDisponibles;
    }

    private Guardaropa filtrarPrendasAcorde(Clima climaActual) {
        Map<Categoria,List<Prenda>> prendasAcordeClima = new HashMap<>(prendasDisponibles).entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, valor ->  valor.getValue().stream().filter(prenda -> prenda.satisfaceCondicionesDe(climaActual)).collect(Collectors.toList())));
        return new Guardaropa(prendasAcordeClima);
    }

    public Guardaropa(){

    }
}
