package ropa;

import clima.Clima;
import clima.InformanteClima;

public class AtuendoSuggester{
    public Atuendo getSugerenciaDe(Guardaropa userGuardaropa){
        Clima climaActual = InformanteClima.getInstance().obtenerClimaEnBuenosAires();
        Guardaropa guardaropaAcordeAlClima = userGuardaropa.filtrarPrendasAcorde(climaActual);
        Prenda prendaSuperior = guardaropaAcordeAlClima.getOf(Categoria.PARTE_SUPERIOR);
        Prenda prendaInferior = guardaropaAcordeAlClima.getOf(Categoria.PARTE_INFERIOR);
        Prenda prendaCalzado = guardaropaAcordeAlClima.getOf(Categoria.CALZADO);
        return new Atuendo(prendaSuperior,prendaInferior,prendaCalzado);
    }

}
