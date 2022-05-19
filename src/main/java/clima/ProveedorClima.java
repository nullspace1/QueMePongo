package clima;

import java.util.List;

public interface ProveedorClima {
    public List<Clima> getWeather(String lugar);

    int tiempoDeValidezDeDatos();
}
