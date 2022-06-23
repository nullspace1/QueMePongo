package Admin;

import clima.Alerta;
import java.util.List;
import ropa.Usuario;

public class UserContainer {
  private final DataProvider proveedorUsuarios;

  public UserContainer(DataProvider dataProvider) {
    this.proveedorUsuarios = dataProvider;
  }
  public List<Usuario> getUsuarios() {
    return proveedorUsuarios.getDataFrom("USUARIOS");
  }
  public void notificarUsuarios(List<Alerta> alertasMasRecientes) {
    getUsuarios().forEach(usuario -> usuario.recibirNotificacion(alertasMasRecientes));
  }

  public void generarNuevasSugerencias(){
    getUsuarios().forEach(Usuario::generarSugerenciaDiaria);
  }

}
