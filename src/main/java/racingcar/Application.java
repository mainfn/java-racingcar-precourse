package racingcar;

import racingcar.model.Printer;
import racingcar.model.RandomNumberGenerator;
import racingcar.model.Reader;

public class Application {

  public static void main(String[] args) {
    Reader reader = new Reader();
    Printer printer = new Printer();
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(0, 9);
    GameManager gameManager = new GameManager(reader, printer, randomNumberGenerator);

    gameManager.start();
  }
}
