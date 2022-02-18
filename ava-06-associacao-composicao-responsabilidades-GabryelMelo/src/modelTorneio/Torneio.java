package modelTorneio;

import java.time.Year;
import java.util.ArrayList;

public class Torneio {

  private final String nome;
  private final String cidade;
  private final int ano;
  private final int vagas;
  private int vagasRemanescentes;

  ArrayList<Equipe> equipes = new ArrayList<>();
  ArrayList<Partida> historicoPartidas = new ArrayList<>();
  static final int YEAR = Year.now().getValue();

  public Torneio(String nome, String cidade, int ano){
    if(nome.isEmpty() || nome.isBlank() || cidade.isBlank() || cidade.isEmpty() || ano > YEAR){
      throw new IllegalArgumentException("Argumentos invalidos.");
    }
    this.nome = nome;
    this.cidade = cidade;
    this.ano = ano;
    this.vagas = 8;
    this.vagasRemanescentes = vagas;
  }

  public String getNome() {
    return nome;
  }

  public String getCidade() {
    return cidade;
  }

  public int getAno() {
    return ano;
  }

  public int getVagasRemanescentes() {
    return vagasRemanescentes;
  }

  public ArrayList<Equipe> getEquipes() {
    return this.equipes;
  }

  public Equipe getEquipe(int i) {
    if (i > this.equipes.size()) {
      return null;
    } else if (i > 0) {
      return this.equipes.get(i - 1);
    }
    return null;
  }

  public ArrayList<Partida> getHistoricoPartidas() {
    return historicoPartidas;
  }

  public Partida getHistoricoPartida(int i) {
    if(i > this.historicoPartidas.size()){
      return null;
    } else if(i > 0){
      return this.historicoPartidas.get(i - 1);
    }
    return null;
  }

  public void novaPartida(String numero, Equipe equipe1, Equipe equipe2) {
    Partida novaPartida = new Partida(numero, equipe1, equipe2, this);
    this.historicoPartidas.add(novaPartida);
  }

  public void inscrever(Equipe equipe) {
    if(this.vagasRemanescentes == 0){
      throw new IllegalStateException("Não há vagas no torneio.");
    } else if(equipe.jogadores.size() < 5) {
      throw new IllegalStateException("Equipe não tem jogadores suficientes.");
    } else {
      this.equipes.add(equipe);
      this.vagasRemanescentes--;
    }
  }

  @Override
  public String toString() {
    return String.format("%s, %s %d", this.nome, this.cidade, this.ano);
  }

  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Torneio){
      Torneio outroTorneio = (Torneio) obj;
      if(this.nome == outroTorneio.nome && this.ano == outroTorneio.ano){
        return true;
      } else {
        return false;
      }
    }
    return false;
  }

}
