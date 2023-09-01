package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public final class Cars {

  private final List<Car> cars;

  private Cars(final List<Car> cars) {
    this.cars = cars;
  }

  public static Cars from(final List<String> carNames) {
    // 2. List<Car>로 변환
    final List<Car> cars = carNames.stream()
        .map(Car::new)
        .collect(Collectors.toList());

    return new Cars(cars);
  }
}
