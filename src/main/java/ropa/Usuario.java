package ropa;

import ropa.Guardaropa;

import java.util.*;

/**
 * 
 */
public class Usuario {

    private final Set<Guardaropa> guardaropas = new HashSet<>();

    public void crearGuardaropas(String nombre){
        Guardaropa guardaropa = new GuardaropaIndividual(nombre,this);
        guardaropas.add(guardaropa);
    }

    public Set<Guardaropa> getGuardaropas() {
        return guardaropas;
    }

   public void aceptarPropuesta(Propuesta propuesta){
        propuesta.hacer(this);
   }

   public void agregarGuardaropas(Guardaropa guardaropa){
        guardaropas.add(guardaropa);
   }

}