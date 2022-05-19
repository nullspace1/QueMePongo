package ropa;

import clima.Clima;

public class Prenda {

  private TipoPrenda tipo;
  private Composicion composicion;
  private Trama trama;
  private Color colorPrimario;
  private Color colorSecundario;

  private Integer temperaturaMaxima;


  public Prenda(TipoPrenda tipo, Color colorPrimario, Color colorSecundario,
      Composicion composicion, Trama trama,Integer temperaturaMaxima) {
    this.tipo = tipo;
    this.colorPrimario = colorPrimario;
    this.colorSecundario = colorSecundario;
    this.composicion = composicion;
    this.trama = trama;
    this.temperaturaMaxima = temperaturaMaxima;
  }
  public Trama getTrama() {
    return this.trama;
  }

  public boolean tieneCategoria(Categoria parteSuperior) {
    return (this.tipo.getCategoria() == parteSuperior);
  }

  public boolean satisfaceCondicionesDe(Clima climaActual) {
    return climaActual.getTemperatura() <= this.temperaturaMaxima;
  }
  public Categoria getCategoria() {
    return this.tipo.getCategoria();
  }
}
