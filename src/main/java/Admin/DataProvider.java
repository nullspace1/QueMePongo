package Admin;

import java.util.List;
import ropa.Usuario;

public interface DataProvider {
   List<Usuario> getDataFrom(String query);

}
