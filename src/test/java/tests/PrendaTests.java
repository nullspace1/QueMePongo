package tests;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import org.junit.jupiter.api.Test;
import prototype.AdministradorUniformes;
import prototype.Uniforme;
import ropa.Color;
import ropa.Composicion;
import ropa.Prenda;
import ropa.PrendaBuilder;
import ropa.PrendaInvalidaException;
import ropa.TipoPrenda;
import ropa.Trama;

public class PrendaTests {



  @Test
  public void tramaPorDefaultEsLisa() {
    PrendaBuilder prendaEnConstruccion = new PrendaBuilder(TipoPrenda.CAMISA);
    prendaEnConstruccion.fijarColorPrimario(new Color(255, 0, 0));
    prendaEnConstruccion.fijarComposicion(Composicion.CUERO);
    Prenda prenda = prendaEnConstruccion.build();
    assertEquals(prenda.getTrama(), Trama.LISA);
  }

  @Test
  public void buildearPrendaIncompletaExplota() {
    PrendaBuilder prendaEnConstruccion = new PrendaBuilder(TipoPrenda.CAMISA);
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

  public Uniforme crearUniforme(String institucion) {
    Prenda prendaSuperior = prendaSuperior();
    Prenda prendaInferior = prendaInferior();
    Prenda calzado = calzado();
    return new Uniforme(prendaSuperior, prendaInferior, calzado, institucion);
  }



  private Prenda prendaSuperior() {
    return new PrendaBuilder(TipoPrenda.CAMISA).fijarColorPrimario(new Color(100, 100, 100))
        .fijarComposicion(Composicion.CUERO).build();
  }

  private Prenda prendaInferior() {
    return new PrendaBuilder(TipoPrenda.PANTALON).fijarColorPrimario(new Color(100, 100, 100))
        .fijarComposicion(Composicion.JEAN).build();
  }

  private Prenda calzado() {
    return new PrendaBuilder(TipoPrenda.ZAPATOS).fijarColorPrimario(new Color(100, 100, 100))
        .fijarComposicion(Composicion.CUERO).build();
  }

  // Iba a ser un test, pero resulto siendo mas un use case para orientarme. Lo dejo para
  // facilitar la correcion del ejercicio.

  public void testCreacionDePrenda() {
    PrendaBuilder prendaEnConstruccion = new PrendaBuilder(TipoPrenda.CAMISA);
    prendaEnConstruccion.fijarColorPrimario(new Color(255, 0, 0));
    prendaEnConstruccion.fijarComposicion(Composicion.CUERO);
    prendaEnConstruccion.fijarTrama(Trama.ESTAMPADO);
    Prenda prendaResultante = prendaEnConstruccion.build();
  }


}
