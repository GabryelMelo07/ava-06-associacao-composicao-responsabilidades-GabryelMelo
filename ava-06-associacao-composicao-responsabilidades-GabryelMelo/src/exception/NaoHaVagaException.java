package exception;

public class NaoHaVagaException extends RuntimeException {

  public NaoHaVagaException() {
    super("Não há mais vagas para essa atividade.");
  }

}
