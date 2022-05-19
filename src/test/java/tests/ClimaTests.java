package tests;

import clima.Clima;
import clima.InformanteClima;
import clima.ProveedorClima;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class ClimaTests {
    private ProveedorClima mockProveedor;
    @BeforeEach
    public void setUp(){
        mockProveedor = mock(ProveedorClima.class);
        InformanteClima.getInstance().reset();
        when(mockProveedor.getWeather(anyString())).thenReturn(listaClima());
        InformanteClima.getInstance().cambiarProveedor(mockProveedor);
    }

    @Test
    public void puedoConocerCondicionesClimaticasDeBuenosAires(){
        InformanteClima.getInstance().obtenerClimaEnBuenosAires();
        verify(mockProveedor).getWeather(anyString());
    }

    @Test
    public void preguntarElClimaMultiplesVecesReutilizaInformacion(){
        InformanteClima.getInstance().obtenerClimaEnBuenosAires();
        InformanteClima.getInstance().obtenerClimaEnBuenosAires();
        verify(mockProveedor,times(1)).getWeather(anyString());
    }

    @Test
    public void sePuedeCambiarProveedor(){
        ProveedorClima otroMockProveedor = mock(ProveedorClima.class);
        when(otroMockProveedor.getWeather(anyString())).thenReturn(listaClima());
        InformanteClima.getInstance().cambiarProveedor(otroMockProveedor);
        InformanteClima.getInstance().obtenerClimaEnBuenosAires();
        verify(otroMockProveedor).getWeather(anyString());
    }


    private List<Clima> listaClima(){
        return Arrays.asList(new Clima(0.0,20.0));
    }

}
