package com.trybe.acc.java.planejamentodeviagem;

/**
 * author joao.
 *
 */
public class Viagem {
  private String embarque;
  private String origem;
  private String destino;
  private double distanciaKm;
  private Voo voo;
  private Tempo tempoViagem;

  /**
   * Método construtor da classe.
   * 
   */
  public Viagem(String embarque, String origem, String destino, double distanciaKm) {
    /* Implemente sua solução aqui (você pode ter que alterar o construtor) */
    this.embarque = embarque;
    this.origem = origem;
    this.destino = destino;
    this.distanciaKm = distanciaKm;
    this.voo = new Voo();
    this.tempoViagem =
        new Tempo(this.embarque, this.origem, this.destino, this.retornarDuracaoVoo());
  }

  /**
   * Método para retorno do horário de Desembarque no Destino.
   * 
   */
  public String retonarDesembarqueHorarioLocalDestino() {
    return this.tempoViagem.retonarDesembarqueHorarioLocalDestino();
  }

  public String retonarDesembarqueHorarioLocalOrigin() {
    return this.tempoViagem.retonarDesembarqueHorarioLocalOrigem();

  }

  // aqui consideramos que um aviao percorre em media 700 km a cada hora
  public int retornarDuracaoVoo() {
    /* Implemente sua solução aqui */
    return this.voo.retornarTempoVoo(distanciaKm);
  }

  /**
   * Método para retorno da informaçao da viagem.
   * 
   */
  public String retornarInformacaoViagem() {
    String horarioLocalDestino = this.retonarDesembarqueHorarioLocalDestino();
    String horarioLocalOrig = this.retonarDesembarqueHorarioLocalOrigin();

    String info = this.voo.retornarInformacaoVoo(this.embarque, this.origem, horarioLocalDestino,
        this.destino);


    String fuso = "Atenção: o desembarque em " + this.destino + " será: " + horarioLocalDestino
        + " no horário de " + this.destino + " e " + horarioLocalOrig + " no horário de "
        + this.origem + "\n";

    return info + fuso;

  }
}
