package racingcar.view;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public final class OutputView {
  public void printInputCarNamesMessage() {
    System.out.println(Message.INPUT_CAR_NAMES);
  }

  public void printInputMaxRoundMessage() {
    System.out.println(Message.INPUT_MAX_ROUND);
  }

  public void printAllRoundResults() {
  }
  public void printWinnersResult() {
    throw new NotImplementedException();
  }
}
