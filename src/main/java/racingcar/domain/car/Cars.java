package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.move.MoveDecider;

public final class Cars {

  private final List<Car> cars;

  private Cars(final List<Car> cars) {
    this.cars = cars;
  }

  public static Cars from(final List<String> carNames) {
    final List<Car> cars = new ArrayList<>();
    for (final String carName : carNames) {
      cars.add(Car.of(carName));
    }
    return new Cars(cars);
  }

  public void moveCarsBy(final MoveDecider moveDecider) {
    for (final Car car : cars) {
      if (moveDecider.canMove()) {
        car.move();
      }
    }
  }

}
