package racingcar;

import java.util.List;
import racingcar.model.Cars;
import racingcar.model.Printer;
import racingcar.model.RandomNumberGenerator;
import racingcar.model.Reader;

public class GameManager {

  private final Reader reader;
  private final Printer printer;
  private final RandomNumberGenerator randomNumberGenerator;

  public GameManager(
      final Reader reader,
      final Printer printer,
      final RandomNumberGenerator randomNumberGenerator
  ) {
    this.reader = reader;
    this.printer = printer;
    this.randomNumberGenerator = randomNumberGenerator;
  }

  public void start() {
    try {
      Cars cars = loadCars();
      System.out.println(cars);
      execute(cars);
      getResult(cars);
    } catch (Exception e) {
      printer.printError(e);
    }
  }

  private Cars loadCars() {
    printer.printReadCarNames();
    List<String> carNames = reader.readCarNames();
    return Cars.from(carNames);
  }

  private void execute(final Cars cars) {
    printer.printReadRoundsToPlays();
    int roundsToPlay = reader.readRoundsToPlay();
    printer.printExecutionResultMessage();

    for (int i = 0; i < roundsToPlay; i++) {
      cars.moveAllByRandomNumber(randomNumberGenerator);
      printer.printExecutionResult(cars);
    }
  }


  private void getResult(final Cars cars) {
    printer.printWinners(cars);
  }
}
