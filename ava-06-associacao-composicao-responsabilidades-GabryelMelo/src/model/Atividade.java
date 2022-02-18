package model;

import java.util.ArrayList;
import exception.*;

public class Atividade {

  public enum Tipo {
    Seminario,
    Minicurso,
    Oficina,
    Palestra
  }

  private final String descricao;
  private final int vagas;
  private int vagasRemanescentes;
  private final int horas;
  private final Tipo tipo;
  private Evento evento;
  private Ministrante ministrante;

  ArrayList<Inscrito> inscritos = new ArrayList<>();

  Atividade(String descricao, int vagas, Tipo tipo, Evento evento) {
    if (descricao.isEmpty() || descricao.isBlank() || vagas < 0) {
      throw new IllegalArgumentException("Argumentos inválidos.");
    }
    this.descricao = descricao;
    this.vagas = vagas;
    this.horas = 0;
    this.tipo = tipo;
    this.evento = evento;
    this.vagasRemanescentes = vagas;
  }

  Atividade(String descricao, int vagas, int horas, Tipo tipo, Evento evento) {
    if (descricao.isEmpty() || descricao.isBlank() || vagas < 0 || horas < 0) {
      throw new IllegalArgumentException("Argumentos inválidos.");
    }
    this.descricao = descricao;
    this.vagas = vagas;
    this.horas = horas;
    this.tipo = tipo;
    this.evento = evento;
    this.vagasRemanescentes = vagas;
  }

  Atividade(String descricao, Ministrante ministrante, int vagas, int horas, Tipo t, Evento evento) {
    if(descricao.isEmpty() || descricao.isBlank() || vagas < 0 || horas < 0){
      throw new IllegalArgumentException("Argumentos inválidos.");
    }
    this.descricao = descricao;
    this.ministrante = ministrante;
    this.vagas = vagas;
    this.horas = horas;
    this.tipo = t;
    this.evento = evento;
    this.vagasRemanescentes = vagas;
  }

  Atividade(String descricao, Ministrante ministrante, Tipo t, Evento evento) {
    if(descricao.isEmpty() || descricao.isBlank()){
      throw new IllegalArgumentException("Descrição inválida.");
    }
    this.descricao = descricao;
    this.ministrante = ministrante;
    this.vagas = 0;
    this.horas = 0;
    this.tipo = t;
    this.evento = evento;
    this.vagasRemanescentes = vagas;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public int getVagas() {
    return this.vagas;
  }

  public int getHoras() {
    return this.horas;
  }

  public Tipo getTipo() {
    return this.tipo;
  }

  public int getAno() {
    return evento.getAno();
  }

  public Evento getEvento() {
    return evento;
  }

  public Ministrante getMinistrante() {
    return ministrante;
  }

  public ArrayList<Inscrito> getInscritos() {
    return this.inscritos;
  }

  public int getQuantidadeInscritos() {
    return this.inscritos.size();
  }

  public Inscrito getInscrito(int i) {
    if (i > this.inscritos.size()) {
      throw new IllegalArgumentException("Indice maior que o tamanho da lista.");
    } else if (i > 0){
      return this.inscritos.get(i - 1);
    }
    return null;
  }

  public int getVagasRemanescentes() {
    return this.vagasRemanescentes;
  }

  public Inscrito inscrever(String nome) {
    if(this.vagas > 0 && this.vagasRemanescentes == 0){
      throw new NaoHaVagaException();
    } else if (nome.isEmpty() || nome.isBlank()){
      throw new IllegalArgumentException("Nome inválido");
    } else {
      Inscrito novoInscrito = new Inscrito(nome);
      this.inscritos.add(novoInscrito);
      this.vagasRemanescentes--;
      return novoInscrito;
    }
  }

  @Override
  public String toString() {
    if(this.horas > 0){
      return String.format("Atividade: %s\nVagas: %d\nTipo: %s", this.descricao, this.vagas, this.tipo);
    }
    return String.format("Atividade: %s\nVagas: %d\nDuração %dh\nTipo: %s", this.descricao, this.vagas, this.horas, this.tipo);
  }

  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Atividade){
      Atividade outraAtividade = (Atividade) obj;
      if(this.evento == outraAtividade.evento || this.ministrante == outraAtividade.ministrante){
        return true;
      } else {
        return false;
      }
    }
    return false;
  }

}
