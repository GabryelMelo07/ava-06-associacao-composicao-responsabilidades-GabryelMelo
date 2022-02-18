package model;

public class Inscrito {

  private final String nome;
  private Chave chave;
  private boolean presenca = false;

  Inscrito(String nome) {
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
    return chave;
  }

  public boolean isConcluido() {
    return this.presenca;
  }

  public void confirmarPresenca() {
    this.presenca = true;
  }

  @Override
  public String toString() {
    return this.nome;
  }

  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Inscrito){
      Inscrito outroInscrito = (Inscrito) obj;
      if(this.chave == outroInscrito.chave){
        return true;
      } else {
        return false;
      }
    }
    return false;
  }
}
