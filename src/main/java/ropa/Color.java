package ropa;

public class Color {

  private Integer rojo;
  private Integer azul;
  private Integer verde;

  public Color(Integer rojo, Integer azul, Integer verde) throws InvalidColorException {
    if (intervaloNoValido(rojo, azul, verde)) {
      throw new InvalidColorException(
          "Los valores de rojo, azul y verde toman valores unicamente entre 0-255 inclusive");
    } else {
      this.rojo = rojo;
      this.azul = azul;
      this.verde = verde;
    }
  }

  private boolean intervaloNoValido(Integer red, Integer blue, Integer green) {
    boolean redInterval = 0 <= red && red <= 255;
    boolean blueInterval = 0 <= blue && blue <= 255;
    boolean greenInterval = 0 <= green && green <= 255;
    return (!redInterval || !blueInterval || !greenInterval);
  }

}
