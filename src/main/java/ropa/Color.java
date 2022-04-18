package ropa;

public class Color {
	
	private Integer red;
	private Integer blue;
	private Integer green;
	
	public Color(Integer red, Integer blue, Integer green) throws InvalidColorException
	{
		if (intervaloNoValido(red,blue,green))
		{
			throw new InvalidColorException("Los valores de rojo, azul y verde toman valores unicamente entre 0-255 inclusive");
		}
		else {
			this.red = red;
			this.blue = blue;
			this.green = green;
		}
	}

	private boolean intervaloNoValido(Integer red, Integer blue, Integer green) {
		boolean redInterval = 0 <= red && red <= 255;
		boolean blueInterval = 0 <= blue && blue <= 255;
		boolean greenInterval = 0 <= green && green <= 255;
		return (!redInterval || !blueInterval || !greenInterval);
	}

}
