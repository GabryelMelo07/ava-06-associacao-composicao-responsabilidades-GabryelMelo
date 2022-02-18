package modelTorneio;

import java.util.ArrayList;

public class Equipe {

  private final String nome;
  private final int vagas;
  private int vagasRemanescentes;

  ArrayList<Jogador> jogadores = new ArrayList<>();

  public Equipe(String nome) {
    if(nome.isEmpty() || nome.isBlank()){
      throw new IllegalArgumentException("Nome invalido.");
    }
    this.nome = nome;
    this.vagas = 5; // Toda Equipe tem 5 vagas por padrão.
    this.vagasRemanescentes = this.vagas;
  }

  public String getNome() {
    return this.nome;
  }

  public int getVagasRemanescentes() {
    return this.vagasRemanescentes;
  }

  public ArrayList<Jogador> getJogadores() {
    return this.jogadores;
  }

  public Jogador getJogador(int i) {
    if (i > this.jogadores.size()) {
      return null;
    } else if (i > 0) {
      return this.jogadores.get(i - 1);
    }
    return null;
  }

  public Jogador inscreverJogador(String nome) {
    if(this.vagasRemanescentes == 0){
      throw new IllegalStateException("Não há vagas na equipe.");
    }
    Jogador novoJogador = new Jogador(nome);
    this.jogadores.add(novoJogador);
    this.vagasRemanescentes--;
    return novoJogador;
  }

  @Override
  public String toString() {
    return this.nome;
  }

  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Equipe){
      Equipe outraEquipe = (Equipe) obj;
      if(this.nome == outraEquipe.nome){
        return true;
      } else {
        return false;
      }
    }
    return false;
  }

}
