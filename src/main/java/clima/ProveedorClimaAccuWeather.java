package clima;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProveedorClimaAccuWeather implements ProveedorClima{
    @Override
    public List<Clima> getWeather(String lugar) {
        List<Map<String, Object>> climateData = new AccuWeatherAPI().getWeather(lugar);
        return climateData.stream().map(x -> obtenerClima(x)).collect(Collectors.toList());
    }

    private Clima obtenerClima(Map<String,Object> dato){
        return new Clima((Double)dato.get("PrecipitationProbability"),enCelcius((Double) dato.get("Temperature")));
    }

    private Double enCelcius(Double temperaturaEnMalasUnidades){
        return (temperaturaEnMalasUnidades - 32.0) * 5.0 / 9.0;
    }
}
