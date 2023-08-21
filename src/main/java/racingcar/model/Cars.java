package racingcar.model;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Cars {

  private final List<Car> cars;
  private int maxPosition;

  private Cars(List<Car> cars) {
    this.cars = cars;
    this.maxPosition = 0;
  }

  public static Cars from(List<String> carNames) {
    return new Cars(carNames
        .stream()
        .map(Car::new)
        .collect(Collectors.toList()));
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < cars.size(); i++) {
      stringBuilder.append(cars.get(i).getName());

      if (i < cars.size() - 1) {
        stringBuilder.append(", ");
      }
    }
    return stringBuilder.toString();
  }

  public void moveAllByRandomNumber(RandomNumberGenerator randomNumberGenerator) {
    this.cars.forEach(car -> {
      int nextPosition = car.getPosition();
      if (canForward(randomNumberGenerator)) {
        car.moveTo(++nextPosition);
        maxPosition = Math.max(nextPosition, maxPosition);
      }
    });
  }

  private boolean canForward(RandomNumberGenerator randomNumberGenerator) {
    return randomNumberGenerator.generateNumber() >= 4;
  }

  public Cars filterWinners() {
    return new Cars(cars.stream()
        .filter(cars -> cars.getPosition() == maxPosition)
        .collect(Collectors.toList())
    );
  }

  @Override
  protected void finalize() throws Throwable {
    super.finalize();
  }

  public void forEach(Consumer<Car> action) {
    cars.forEach(action);
  }

  public int size() {
    return cars.size();
  }
}
