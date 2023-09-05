package racingcar.model;

import java.util.List;
import racingcar.domain.Car;

public final class GameResult {

  private final List<Car> cars;

  private GameResult(final List<Car> cars) {
    this.cars = cars;
  }

  public static GameResult from(final List<Car> cars) {
    return new GameResult(cars);
  }

  public List<Car> getCars() {
    return cars;
  }
}
