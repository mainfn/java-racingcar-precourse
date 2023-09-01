package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Car {

  private final String name;
  private final List<Integer> positionsByRound = new ArrayList<>();

  public Car(String name) {
    this.name = name;
  }

  // domain/Car.java
  public void move() {
    Integer nextPosition = getLastPosition();

    if (Randoms.pickNumberInRange(0, 9) >= 4) {
      nextPosition++;
    }

    positionsByRound.add(nextPosition);
  }

  private Integer getLastPosition() {
    if (positionsByRound.isEmpty()) {
      return 0;
    }
    return positionsByRound.get(positionsByRound.size() - 1);
  }

  public String getName() {
    return name;
  }

  public List<Integer> getPositionsByRound() {
    return positionsByRound;
  }
}
