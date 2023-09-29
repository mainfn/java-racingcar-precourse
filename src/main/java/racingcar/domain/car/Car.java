package racingcar.domain.car;

public final class Car {

  private final String name;
  private int position = 0;

  public Car(final String name) {
    validateCarName(name);
    this.name = name;
  }

  public static Car of(final String name) {
    return new Car(name);
  }

  public void move() {
    position++;
  }

  public String getName() {
    return name;
  }

  public int getPosition() {
    return position;
  }

  private void validateCarName(final String carName) {
    if (carName == null || carName.isEmpty()) {
      throw new IllegalArgumentException("차 이름을 입력해주세요.");
    }
    if (carName.length() > 5) {
      throw new IllegalArgumentException("차 이름은 5자 이하만 가능합니다.");
    }
  }
}
