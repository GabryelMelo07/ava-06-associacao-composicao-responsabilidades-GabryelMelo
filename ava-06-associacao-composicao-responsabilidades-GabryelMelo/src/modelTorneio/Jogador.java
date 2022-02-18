package modelTorneio;

import model.Chave;

public class Jogador {

  private final String nome;
  private final Chave chave;

  Jogador(String nome) {
    if(nome.isEmpty() || nome.isBlank()){
      throw new IllegalArgumentException("Nome inválido.");
    }
    this.nome = nome;
    this.chave = Chave.gerarChave();
  }

  public String getNome() {
    return this.nome;
  }

  public Chave getChave() {
    return this.chave;
  }

  @Override
  public String toString() {
    return String.format("%s", this.nome);
  }

  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Jogador){
      Jogador outroJogador = (Jogador) obj;
      if(this.nome == outroJogador.nome){
        return true;
      } else {
        return false;
      }
    }
    return false;
  }

}
