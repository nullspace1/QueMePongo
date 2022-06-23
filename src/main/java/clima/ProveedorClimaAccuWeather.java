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
    public Clima getWeather(String lugar) {
        List<Map<String, Object>> rawClimateData = new AccuWeatherAPI().getWeather(lugar);
        return obtenerClimaDeRawData(rawClimateData);
    }

    @Override
    public List<Alerta> getAlertas(String lugar) {
        AccuWeatherAPI apiClima = new AccuWeatherAPI();
        Map<String, List<String>> alertas = apiClima.getAlertas("Buenos Aires");
       return alertas.get("CurrentAlerts").stream().map(this::traducirAlerta).collect(Collectors.toList());
    }

    private Alerta traducirAlerta(String alertaEnIngles) {
        // no va al caso para el ejercicio
        return Alerta.GRANIZO;
    }

    public Clima obtenerClimaDeRawData(List<Map<String,Object>> rawData){
       return rawData.stream().map(this::obtenerClima).collect(Collectors.toList()).get(0);
    }


    private Clima obtenerClima(Map<String,Object> dato){
        return new Clima((Double)dato.get("PrecipitationProbability"),enCelcius((Integer)(((HashMap<String, Object>)dato.get("Temperature")).get("Value"))));
    }

    private Integer enCelcius(Integer temperaturaEnMalasUnidades){
        return Integer.divideUnsigned((temperaturaEnMalasUnidades - 32)*5,9);
    }




}
