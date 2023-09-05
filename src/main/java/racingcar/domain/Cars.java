package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.GameResult;

public final class Cars {

  private final List<Car> cars;

  private Cars(final List<Car> cars) {
    this.cars = cars;
  }

  public static Cars from(final List<String> carNames) {
    final List<Car> cars = carNames.stream()
        .map(Car::new)
        .collect(Collectors.toList());

    return new Cars(cars);
  }

  public void moveAllRounds(final int rounds) {
    for (int round = 0; round < rounds; round++) {
      for (final Car car : cars) {
        car.move();
      }
    }
  }

  public GameResult into() {
    return GameResult.from(cars);
  }
}
