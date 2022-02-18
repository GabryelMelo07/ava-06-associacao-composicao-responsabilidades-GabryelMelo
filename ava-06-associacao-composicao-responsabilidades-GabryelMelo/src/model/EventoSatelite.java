package model;

import java.util.ArrayList;
import model.Evento.Tipo;

public class EventoSatelite {

  private final String descricao;
  private final Tipo tipo;
  private Evento evento;

  ArrayList<Inscrito> inscritos = new ArrayList<>();

  EventoSatelite(String descricao, model.Evento.Tipo t, Evento evento) {
    if(descricao.isEmpty() || descricao.isBlank()){
      throw new IllegalArgumentException("Descrição inválida");
    }
    this.descricao = descricao;
    this.tipo = t;
    this.evento = evento;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public Tipo getTipo() {
    return this.tipo;
  }

  public String getCidade() {
    return evento.getCidade();
  }

  public Evento getEventoCentral() {
    return evento;
  }

  public void inscrever(String nome) {
    if(nome.isBlank() || nome.isEmpty()){
      throw new IllegalArgumentException("Nome inválido.");
    }
    Inscrito novoInscrito = new Inscrito(nome);
    this.inscritos.add(novoInscrito);
  }

  public int getQuantidadeInscritos() {
    return this.inscritos.size();
  }

  public Inscrito getInscrito(int i) {
    if (i > this.inscritos.size()) {
      throw new IllegalArgumentException("Indice maior que o tamanho da lista.");
    } else if (i > 0) {
      return this.inscritos.get(i - 1);
    }
    return null;
  }

  @Override
  public String toString() {
    return this.descricao;
  }

}
