package tests;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Set;

import clima.Clima;
import clima.InformanteClima;
import clima.ProveedorClima;
import org.junit.jupiter.api.Test;
import prototype.AdministradorUniformes;
import prototype.Uniforme;
import ropa.*;

public class PrendaTests {


  @Test
  public void tramaPorDefaultEsLisa() {
    Borrador prendaEnConstruccion = new Borrador(Trama.LISA);
    prendaEnConstruccion.fijarTipo(TipoPrenda.CAMISA);
    prendaEnConstruccion.fijarColorPrimario(new Color(255, 0, 0));
    prendaEnConstruccion.fijarComposicion(Composicion.CUERO);
    prendaEnConstruccion.fijarTemperaturaMaxima(10);
    Prenda prenda = prendaEnConstruccion.build();
    assertEquals(prenda.getTrama(), Trama.LISA);
  }

  @Test
  public void buildearPrendaIncompletaExplota() {
    Borrador prendaEnConstruccion = new Borrador(Trama.LISA);
    prendaEnConstruccion.fijarTipo(TipoPrenda.CAMISA);
    prendaEnConstruccion.fijarComposicion(Composicion.CUERO);
    RuntimeException excepcion =
        assertThrows(PrendaInvalidaException.class, (() -> prendaEnConstruccion.build()));
    assertEquals(excepcion.getMessage(),
        "No se puede construir la prenda, tiene componentes faltantes!");
  }

  @Test
  public void configurarUniforme() {
    String institucion = "Institutest";
    Uniforme uniforme = crearUniforme(institucion);
    AdministradorUniformes.agregarUniforme(uniforme);
    assertEquals(uniforme, AdministradorUniformes.getUniforme(institucion));
  }


  @Test
  public void recibirSugerencias() {
    String institucion = "Institutest";
    Uniforme uniforme = crearUniforme(institucion);
    AdministradorUniformes.agregarUniforme(uniforme);
    Set<Uniforme> sugerencias = AdministradorUniformes.getSugerencias();
    assertTrue(sugerencias.contains(uniforme));
  }

  @Test
  public void recibirSugerenciaAtuendosEnBaseALaRopa(){
    Guardaropa guardaropa = new Guardaropa();
    guardaropa.add(prendaInferior());
    Atuendo atuendo = guardaropa.getSugerencia();
    assertEquals(atuendo.getDeCategoria(Categoria.PARTE_INFERIOR).getTrama(),prendaInferior().getTrama());
  }

  @Test
  public void sugerenciasFiltraAcordeATemperatura(){
    fijarClima();
    Guardaropa guardaropa = new Guardaropa();
    guardaropa.add(prendaQuePasa());
    guardaropa.add(prendaQueNoPasa());
    Atuendo atuendo = guardaropa.getSugerencia();
    assertEquals(atuendo.getDeCategoria(Categoria.PARTE_SUPERIOR).getTrama(),prendaQuePasa().getTrama());
  }

  public Uniforme crearUniforme(String institucion) {
    Prenda prendaSuperior = prendaSuperior();
    Prenda prendaInferior = prendaInferior();
    Prenda calzado = calzado();
    return new Uniforme(prendaSuperior, prendaInferior, calzado, institucion);
  }

  private Prenda prendaSuperior() {
    return new Borrador(Trama.CUADRADO).fijarTipo(TipoPrenda.CAMISA)
        .fijarColorPrimario(new Color(100, 100, 100)).fijarComposicion(Composicion.CUERO).fijarTemperaturaMaxima(200).build();
  }

  private Prenda prendaQueNoPasa(){
    return new Borrador(Trama.CUADRADO).fijarTipo(TipoPrenda.CAMISA)
            .fijarColorPrimario(new Color(100, 100, 100)).fijarComposicion(Composicion.JEAN).fijarTemperaturaMaxima(10).build();
  }

  private Prenda prendaQuePasa(){
    return new Borrador(Trama.CUADRADO).fijarTipo(TipoPrenda.CAMISA)
            .fijarColorPrimario(new Color(100, 100, 100)).fijarComposicion(Composicion.CUERO).fijarTemperaturaMaxima(25).build();
  }

  private Prenda prendaInferior() {
    return new Borrador(Trama.LISA).fijarTipo(TipoPrenda.PANTALON)
        .fijarColorPrimario(new Color(100, 100, 100)).fijarComposicion(Composicion.JEAN).fijarTemperaturaMaxima(200).build();
  }

  private Prenda calzado() {
    return new Borrador(Trama.LISA).fijarTipo(TipoPrenda.ZAPATOS)
        .fijarColorPrimario(new Color(100, 100, 100)).fijarComposicion(Composicion.CUERO).fijarTemperaturaMaxima(200).build();
  }

  private void fijarClima(){
    ProveedorClima proveedorClima = mock(ProveedorClima.class);
    when(proveedorClima.getWeather(anyString())).thenReturn(Arrays.asList(new Clima(0.0,15)));
    InformanteClima.getInstance().cambiarProveedor(proveedorClima);
  }




}
