package racingcar.exception;

public class InvalidRoundsToPlayException extends IllegalArgumentException {

  public InvalidRoundsToPlayException() {
    super("시도 횟수는 숫자여야 한다.");
  }
}
