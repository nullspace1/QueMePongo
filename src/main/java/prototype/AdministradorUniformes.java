package prototype;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AdministradorUniformes {

  static private Map<String, Uniforme> uniformes = new HashMap<String, Uniforme>();

  public static void agregarUniforme(Uniforme uniforme) {
    uniformes.put(uniforme.getInstitucion(), uniforme);
  }

  public static Set<Uniforme> getSugerencias() {
    return uniformes.values().stream().collect(Collectors.toSet());
  }

  public static Uniforme getUniforme(String institucion) {
    return uniformes.get(institucion);
  }

}
