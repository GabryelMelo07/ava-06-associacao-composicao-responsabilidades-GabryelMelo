package model;

public class Ministrante {

  private final String nome;
  private final String descricao;

  public Ministrante(String nome, String descricao) {
    this.nome = nome;
    this.descricao = descricao;
  }

  public String getNome() {
    return this.nome;
  }

  public String getDescricao() {
    return descricao;
  }

  @Override
  public String toString() {
    return this.nome;
  }

  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Ministrante){
      Ministrante outroMinistrante = (Ministrante) obj;
      if(this.nome == outroMinistrante.nome && this.descricao == outroMinistrante.descricao){
        return true;
      } else {
        return false;
      }
    }
    return false;
  }

}
