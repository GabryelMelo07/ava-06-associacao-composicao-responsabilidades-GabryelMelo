package model;

import java.util.ArrayList;

public class Evento {

  public enum Tipo {
    SEMANA,
    Escola,
    Salao,
    Seminario,
    Mostra
  }

  private final String nome;
  private final String cidade;
  private final Tipo duracao;
  private final int ano;
  private ArrayList<Atividade> atvs = new ArrayList<>();
  private ArrayList<EventoSatelite> eventoSatelites = new ArrayList<>();

  public Evento(String nome, String cidade, Tipo t, int ano){
    if(nome.isEmpty() || nome.isBlank() || cidade.isEmpty() || cidade.isBlank()){
      throw new IllegalArgumentException("Argumentos ilegais.");
    }
    this.nome = nome;
    this.cidade = cidade;
    this.duracao = t;
    this.ano = ano;
  }

  public String getNome() {
    return this.nome;
  }

  public Tipo getTipo() {
    return this.duracao;
  }

  public String getCidade() {
    return this.cidade;
  }

  public int getAno() {
    return this.ano;
  }

  public ArrayList<Atividade> getAtividades() {
    return this.atvs;
  }

  public Atividade getAtividade(int i) {
    if(i >= 1){
      return this.atvs.get(i - 1);
    } else if(i > atvs.size()){
      return null;
    }
    return null;
  }

  public ArrayList<EventoSatelite> getEventosSatelites() {
    return eventoSatelites;
  }

  public EventoSatelite getEventoSatelite(int i) {
    if (i >= 1) {
      return this.eventoSatelites.get(i - 1);
    } else if (i > eventoSatelites.size()) {
      return null;
    }
    return null;
  }

  public Atividade novaAtividade(String nome, int vagas, model.Atividade.Tipo t) {
    if(nome.isEmpty() || nome.isBlank() || vagas < 0){
      throw new IllegalArgumentException("Argumentos ilegais.");
    }
    Atividade novaAtividade = new Atividade(nome, vagas, t, this);
    this.atvs.add(novaAtividade);
    return novaAtividade;
  }

  public Atividade novaAtividade(String nome, int vagas, int horas, model.Atividade.Tipo t) {
    if(nome.isEmpty() || nome.isBlank() || vagas < 0 || horas < 0){
      throw new IllegalArgumentException("Argumentos ilegais.");
    }
    Atividade novaAtividade = new Atividade(nome, vagas, horas, t, this);
    this.atvs.add(novaAtividade);
    return novaAtividade;
  }

  public Atividade novaAtividade(String nome, Ministrante ministrante, int vagas, int horas, model.Atividade.Tipo t) {
    if (nome.isEmpty() || nome.isBlank() || vagas < 0 || horas < 0) {
      throw new IllegalArgumentException("Argumentos ilegais.");
    }
    Atividade novaAtividade = new Atividade(nome, ministrante, vagas, horas, t, this);
    this.atvs.add(novaAtividade);
    return novaAtividade;
  }

  public Atividade novaAtividade(String nome, Ministrante ministrante, model.Atividade.Tipo t) {
    if (nome.isEmpty() || nome.isBlank()) {
      throw new IllegalArgumentException("Argumentos ilegais.");
    }
    Atividade novaAtividade = new Atividade(nome, ministrante, t, this);
    this.atvs.add(novaAtividade);
    return novaAtividade;
  }

  public EventoSatelite novoEventoSatelite(String nome, Tipo t) {
    if (nome.isEmpty() || nome.isBlank()) {
      throw new IllegalArgumentException("Argumentos ilegais.");
    }
    EventoSatelite novoEventoSatelite = new EventoSatelite(nome, t, this);
    this.eventoSatelites.add(novoEventoSatelite);
    return novoEventoSatelite;
  }

  @Override
  public String toString() {
    return this.nome;
  }

  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Evento){
      Evento outroEvento = (Evento) obj;
      if(this.nome == outroEvento.nome){
        return true;
      } else {
        return false;
      }
    }
    return false;
  }

}
