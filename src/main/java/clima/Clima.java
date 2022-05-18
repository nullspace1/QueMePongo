package clima;

import java.util.ArrayList;
import java.util.List;

public class Clima {
    private Double probabilidadLluvia;
    private Double temperatura;

    public Clima(Double probabilidadLluvia, Double temperatura){
        this.probabilidadLluvia = probabilidadLluvia;
        this.temperatura = temperatura;
    }

    public Double getProbabilidadLluvia() {
        return probabilidadLluvia;
    }

    public Double getTemperatura() {
        return temperatura;
    }


}
