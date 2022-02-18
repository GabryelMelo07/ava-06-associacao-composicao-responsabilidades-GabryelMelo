package model;

import java.util.Random;

public class Chave {

  private final String chave;

  private Chave(String chave) {
    this.chave = chave;
  }

  public String getChave() {
    return this.chave;
  }

  public static Chave gerarChave() {
    String caractere = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String chaveAleatoria = "";
    int length = 16;
    Random rand = new Random();
    char[] aux = new char[length];

    for (int i = 0; i < length; i++) {
      aux[i] = caractere.charAt(rand.nextInt(caractere.length()));
    }

    for (int i = 0; i < aux.length; i++) {
      chaveAleatoria += aux[i];
    }
    Chave chaveInscricao = new Chave(chaveAleatoria);

    return chaveInscricao;
  }

  @Override
  public String toString() {
    return this.chave;
  }

  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Chave){
      Chave outraChave = (Chave) obj;
      if(this.chave == outraChave.chave){
        return true;
      } else {
        return false;
      }
    }
    return false;
  }

}
