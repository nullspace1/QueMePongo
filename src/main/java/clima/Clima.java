package clima;

import java.util.ArrayList;
import java.util.List;

public class Clima {
    private final Double probabilidadLluvia;
    private final Integer temperatura;

    public Clima(Double probabilidadLluvia, Integer temperatura){
        this.probabilidadLluvia = probabilidadLluvia;
        this.temperatura = temperatura;
    }

    public Double getProbabilidadLluvia() {
        return probabilidadLluvia;
    }

    public Integer getTemperatura() {
        return temperatura;
    }


}
