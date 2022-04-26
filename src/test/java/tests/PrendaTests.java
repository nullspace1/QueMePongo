package tests;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import ropa.Color;
import ropa.Composicion;
import ropa.Prenda;
import ropa.PrendaBuilder;
import ropa.PrendaInvalidaException;
import ropa.TipoPrenda;
import ropa.Trama;

public class PrendaTests {

  // Iba a ser un test, pero resulto siendo mas un use case para orientarme. Lo dejo para
  // facilitar la correcion del ejercicio.

  /*
   * public void testCreacionDePrenda() { PrendaFactory prendaEnConstruccion =
   * PrendaFactory.iniciarPrenda(TipoPrenda.CAMISA); prendaEnConstruccion.fijarColorPrimario(new
   * Color(255, 0, 0)); prendaEnConstruccion.fijarComposicion(Composicion.CUERO);
   * prendaEnConstruccion.fijarTrama(Trama.ESTAMPADO); Prenda prendaResultante =
   * prendaEnConstruccion.build(); }
   */

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

}
