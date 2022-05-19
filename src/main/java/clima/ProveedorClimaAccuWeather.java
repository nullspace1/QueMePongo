package clima;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ProveedorClimaAccuWeather implements ProveedorClima{

    @Override
    public List<Clima> getWeather(String lugar) {
        List<Map<String, Object>> rawClimateData = new AccuWeatherAPI().getWeather(lugar);
        return obtenerClimaDeRawData(rawClimateData);
    }

    public List<Clima> obtenerClimaDeRawData(List<Map<String,Object>> rawData){
       return rawData.stream().map(this::obtenerClima).collect(Collectors.toList());
    }


    @Override
    public int tiempoDeValidezDeDatos() {
        return 12;
    }

    private Clima obtenerClima(Map<String,Object> dato){
        return new Clima((Double)dato.get("PrecipitationProbability"),enCelcius((Integer)(((HashMap<String, Object>)dato.get("Temperature")).get("Value"))));
    }

    private Integer enCelcius(Integer temperaturaEnMalasUnidades){
        return Integer.divideUnsigned((temperaturaEnMalasUnidades - 32)*5,9);
    }




}
