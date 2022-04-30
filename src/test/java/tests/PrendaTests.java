package tests;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import org.junit.jupiter.api.Test;
import prototype.AdministradorUniformes;
import prototype.Uniforme;
import ropa.Borrador;
import ropa.Color;
import ropa.Composicion;
import ropa.Prenda;
import ropa.PrendaInvalidaException;
import ropa.TipoPrenda;
import ropa.Trama;

public class PrendaTests {


  @Test
  public void tramaPorDefaultEsLisa() {
    Borrador prendaEnConstruccion = new Borrador(Trama.LISA);
    prendaEnConstruccion.fijarTipo(TipoPrenda.CAMISA);
    prendaEnConstruccion.fijarColorPrimario(new Color(255, 0, 0));
    prendaEnConstruccion.fijarComposicion(Composicion.CUERO);
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

  public Uniforme crearUniforme(String institucion) {
    Prenda prendaSuperior = prendaSuperior();
    Prenda prendaInferior = prendaInferior();
    Prenda calzado = calzado();
    return new Uniforme(prendaSuperior, prendaInferior, calzado, institucion);
  }



  private Prenda prendaSuperior() {
    return new Borrador(Trama.CUADRADO).fijarTipo(TipoPrenda.CAMISA)
        .fijarColorPrimario(new Color(100, 100, 100)).fijarComposicion(Composicion.CUERO).build();
  }

  private Prenda prendaInferior() {
    return new Borrador(Trama.LISA).fijarTipo(TipoPrenda.PANTALON)
        .fijarColorPrimario(new Color(100, 100, 100)).fijarComposicion(Composicion.JEAN).build();
  }

  private Prenda calzado() {
    return new Borrador(Trama.LISA).fijarTipo(TipoPrenda.ZAPATOS)
        .fijarColorPrimario(new Color(100, 100, 100)).fijarComposicion(Composicion.CUERO).build();
  }



}
