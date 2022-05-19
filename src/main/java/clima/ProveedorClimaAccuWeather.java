package clima;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ProveedorClimaAccuWeather implements ProveedorClima{

    @Override
    public List<Clima> getWeather(String lugar) {
        List<Map<String, Object>> climateData = new AccuWeatherAPI().getWeather(lugar);
        return climateData.stream().map(this::obtenerClima).collect(Collectors.toList());
    }


    @Override
    public int tiempoDeValidez() {
        return 12;
    }

    private Clima obtenerClima(Map<String,Object> dato){
        return new Clima((Double)dato.get("PrecipitationProbability"),enCelcius((Double) dato.get("Temperature")));
    }

    private Double enCelcius(Double temperaturaEnMalasUnidades){
        return (temperaturaEnMalasUnidades - 32.0) * 5.0 / 9.0;
    }




}
