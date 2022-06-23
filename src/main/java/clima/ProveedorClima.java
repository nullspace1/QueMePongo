package clima;

import java.util.List;

public interface ProveedorClima {
    public Clima getWeather(String lugar);
    public List<Alerta> getAlertas(String lugar);

}
