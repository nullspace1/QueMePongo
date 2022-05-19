package clima;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class InformanteClima {

    private static InformanteClima INSTANCE = new InformanteClima(new ProveedorClimaAccuWeather());
    private ProveedorClima proveedor;
    private List<Clima> ultimosDatosClima;
    private LocalDateTime fechaUltimaObtencion = LocalDateTime.MIN;


    public Clima obtenerClimaEnBuenosAires(){
        if (!hayDatosActualizados()){
            List<Clima> climaNuevo = proveedor.getWeather("Buenos Aires, Argentina");
            actualizarBuffer(climaNuevo);
        }
        return climaAhora();
    }

    private Clima climaAhora() {
        return ultimosDatosClima.get(horasDesdeUltimaMedida().intValue());
    }

    private boolean hayDatosActualizados() {
        return horasDesdeUltimaMedida() <= proveedor.tiempoDeValidezDeDatos();
    }

    private Long horasDesdeUltimaMedida(){
        return TimeUnit.SECONDS.toHours(Duration.between(fechaUltimaObtencion,LocalDateTime.now()).abs().getSeconds());
    }

    private void actualizarBuffer(List<Clima> climaNuevo) {
        ultimosDatosClima = climaNuevo;
        fechaUltimaObtencion = LocalDateTime.now();
    }

    static public InformanteClima getInstance(){
        return INSTANCE;
    }

    public void cambiarProveedor(ProveedorClima proveedor){
        INSTANCE.setProveedor(proveedor);
    }
    private void setProveedor(ProveedorClima proveedor){
        this.proveedor = proveedor;
    }

    private InformanteClima(ProveedorClima proveedor) {
        this.proveedor = proveedor;
    }

    public void reset(){
        INSTANCE.fechaUltimaObtencion = LocalDateTime.MIN;
    }
}
