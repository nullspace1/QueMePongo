package ropa;

import clima.Clima;
import clima.InformanteClima;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Guardaropa {

    protected String nombre;
    private final Map<Categoria,List<Prenda>> prendasDisponibles  = new HashMap<>();
    private final List<Propuesta> propuestasPendientes = new ArrayList<>();
    private final List<Propuesta> propuestasAceptadas = new ArrayList<>();

    public void add(Prenda prenda, Usuario usuario){
        verificarSeguridad(usuario);
        prendasDisponibles.putIfAbsent(prenda.getCategoria(), new ArrayList<>());
        List<Prenda> lista = prendasDisponibles.get(prenda.getCategoria());
        lista.add(prenda);
       prendasDisponibles.put(prenda.getCategoria(), lista);
    }

    public void remove(Prenda prenda, Usuario usuario){
        verificarSeguridad(usuario);
        List<Prenda> listaDondeEsta = prendasDisponibles.get(prenda.getCategoria());
        listaDondeEsta.remove(prenda);
    }

    public void agregarPropuesta(Propuesta propuesta) {
        propuesta.setGuardaropa(this);
        propuestasPendientes.add(propuesta);
    }

    public List<Propuesta> getPropuestasPendientes() {
        return this.propuestasPendientes;
    }

    public List<Propuesta> getPropuestasAceptas() {
        return this.propuestasAceptadas;
    }

    public Atuendo getSugerencia(){
        Clima climaActual = InformanteClima.getInstance().obtenerClimaEnBuenosAires();
        Map<Categoria,List<Prenda>> guardaropaAcordeAlClima = this.filtrarPrendasAcorde(climaActual);
        return tomarAtuendosDe(guardaropaAcordeAlClima);
    }

    private Atuendo tomarAtuendosDe(Map<Categoria,List<Prenda>> guardaropaAcordeAlClima) {
        Atuendo atuendo = new Atuendo();
        guardaropaAcordeAlClima.forEach((k,v) -> atuendo.agregarPrenda(v.stream().findAny().get()));
        return atuendo;
    }

    private Map<Categoria,List<Prenda>> filtrarPrendasAcorde(Clima climaActual) {
        return new HashMap<>(prendasDisponibles).entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, valor ->  valor.getValue().stream().filter(prenda -> prenda.satisfaceCondicionesDe(climaActual)).collect(Collectors.toList())));
    }


    protected abstract void verificarSeguridad(Usuario usuario);
}
