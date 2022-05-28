package ropa;

import java.util.ArrayList;
import java.util.List;

public class GuardaropaCompartido extends Guardaropa{

    private final List<Usuario> usuarioList = new ArrayList<>();

    public GuardaropaCompartido(Usuario usuarioDuenio){
        this.usuarioList.add(usuarioDuenio);
    }
    public void agregarUsuario(Usuario usuarioQueIntento,Usuario usuario){
        verificarSeguridad(usuarioQueIntento);
        usuarioList.add(usuarioQueIntento);
    }

    public void quitarUsuario(Usuario usuarioQueIntento,Usuario usuario){
        verificarSeguridad(usuarioQueIntento);
        usuarioList.add(usuario);
    }

    @Override
    protected void verificarSeguridad(Usuario usuario) {
        if (!usuarioList.contains(usuario)) throw new SecurityException("Este usuario no se le fue compartido el guardaropa");
    }
}
