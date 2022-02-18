package modelTorneio;

public class Partida {

  private final String numero;
  private final Torneio torneio;
  private final Equipe equipe1;
  private final Equipe equipe2;
  private Equipe vencedor;

  Partida (String numero, Equipe equipe1, Equipe equipe2, Torneio torneio) {
    if(equipe2.equals(equipe1)){
      throw new IllegalArgumentException("Equipes não podem ser iguais.");
    }
    this.numero = numero;
    this.equipe1 = equipe1;
    this.equipe2 = equipe2;
    this.torneio = torneio;
  }

  public Torneio getTorneio() {
    return this.torneio;
  }

  public Equipe getEquipe1() {
    return this.equipe1;
  }

  public Equipe getEquipe2() {
    return this.equipe2;
  }

  public Equipe getVencedor() {
    return this.vencedor;
  }

  public void vencedor(Equipe vencedor) {
    this.vencedor = vencedor;
  }

  @Override
  public String toString() {
    return String.format("Partida %s, %s Vs %s", this.numero, this.equipe1, this.equipe2);
  }

  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Partida){
      Partida outraPartida = (Partida) obj;
      if(this.numero == outraPartida.numero){
        return true;
      } else {
        return false;
      }
    }
    return false;
  }

}
