package racingcar.domain.racing;

import static racingcar.util.StringUtils.repeat;

import racingcar.domain.car.Car;

public final class RoundRecord {

  private final String carName;
  private final int position;

  private RoundRecord(
      final String carName,
      final int position
  ) {
    this.carName = carName;
    this.position = position;
  }

  public static RoundRecord from(final Car car) {
    return new RoundRecord(car.getName(), car.getPosition());
  }

  @Override
  public String toString() {
    return carName + " : " + repeat("-", position);
  }

  public String getCarName() {
    return carName;
  }

  public int getPosition() {
    return position;
  }
}
