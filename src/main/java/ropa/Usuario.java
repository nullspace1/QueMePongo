package ropa;

import ropa.Guardaropa;

import java.util.*;

/**
 * 
 */
public class Usuario {

    private final Set<Guardaropa> guardaropas = new HashSet<>();

    public Set<Guardaropa> getGuardaropas() {
        return guardaropas;
    }


    public Guardaropa getGuaradaropasCon(String nombre){
        Optional<Guardaropa> guardaropaOptional = guardaropas.stream().filter(guardaropa -> guardaropa.nombre == nombre).findAny();
        if (guardaropaOptional.isPresent()) return guardaropaOptional.get();
        else throw new NoExisteGuaradaropaException("No se posee un guardaropas con ese nombre!");
    }

   public void agregarGuardaropas(Guardaropa guardaropa){
        guardaropas.add(guardaropa);
   }

}