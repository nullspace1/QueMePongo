package ropa;

import clima.Clima;
import clima.InformanteClima;
import java.util.*;
import java.util.stream.Collectors;

public class Guardaropa {

    protected String nombre;
    private final List<Usuario> usuarios = new ArrayList<>();
    private final Map<Categoria,Set<Prenda>> prendasDisponibles  = new HashMap<>();
    private final List<Propuesta> propuestasPendientes = new ArrayList<>();
    private final List<Propuesta> propuestasAceptadas = new ArrayList<>();



    public Guardaropa(String nombre,Usuario usuarioDuenio){
        this.nombre = nombre;
        this.usuarios.add(usuarioDuenio);
    }
    public void agregarUsuario(Usuario usuarioQueIntento,Usuario usuario){
        usuarios.add(usuario);
    }

    public void quitarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public void add(Prenda prenda){
        prendasDisponibles.putIfAbsent(prenda.getCategoria(), new HashSet<>());
        Set<Prenda> lista = prendasDisponibles.get(prenda.getCategoria());
        lista.add(prenda);
       prendasDisponibles.put(prenda.getCategoria(), lista);
    }

    public void remove(Prenda prenda){
        Set<Prenda> listaDondeEsta = prendasDisponibles.get(prenda.getCategoria());
        listaDondeEsta.remove(prenda);
    }

    public void agregarPropuesta(Propuesta propuesta) {
        propuesta.setGuardaropa(this);
        propuestasPendientes.add(propuesta);
    }

    public List<Propuesta> getPropuestasPendientes() {
        return this.propuestasPendientes;
    }

    public List<Propuesta> getPropuestasAceptadas() {
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

    public Set<Prenda> getListaPrendas(){
        return prendasDisponibles.values().stream().reduce(new HashSet<>(),(x,y)->{x.addAll(y); return x;});
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
