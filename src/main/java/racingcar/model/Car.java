package racingcar.model;

import racingcar.exception.InvalidCarNameException;

public class Car {

  private final String name;
  private int position;

  public Car(String name) {
    validateName(name);
    this.name = name;
    this.position = 0;
  }

  private void validateName(String name) {
    if (name == null || name.isEmpty() || name.length() > 5) {
      throw new InvalidCarNameException();
    }
  }

  // 추가 기능 구현
  public void moveTo(int nextPosition) {
    this.position = nextPosition;
  }

  public String getName() {
    return name;
  }

  public int getPosition() {
    return position;
  }
}
