package ropa;

import java.util.List;
import java.util.Map;

public class GuardaropaIndividual extends Guardaropa{

    private final Usuario usuarioDuenio;

    @Override
    protected void verificarSeguridad(Usuario usuario) {
        if (usuario != usuarioDuenio) throw new SecurityException("Este usuario no es el dueño del guardaropa");
    }

    public GuardaropaIndividual(String nombre,Usuario usuarioDuenio) {
        this.nombre = nombre;
        this.usuarioDuenio = usuarioDuenio;
    }




}
