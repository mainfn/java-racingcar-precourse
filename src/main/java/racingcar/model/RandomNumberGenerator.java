package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

  private final int startNumber;
  private final int endNumber;

  public RandomNumberGenerator(int startNumber, int endNumber) {
    this.startNumber = startNumber;
    this.endNumber = endNumber;
  }

  public int generateNumber() {
    return Randoms.pickNumberInRange(startNumber, endNumber);
  }
}
