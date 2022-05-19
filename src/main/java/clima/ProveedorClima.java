package clima;

import java.time.LocalDateTime;
import java.util.List;

public interface ProveedorClima {
    public List<Clima> getWeather(String lugar);



    int tiempoDeValidez();
}
