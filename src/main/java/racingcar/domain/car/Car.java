package racingcar.domain.car;

public final class Car {

  private final String name;
  private int position = 0;

  public Car(final String name) {
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
}
