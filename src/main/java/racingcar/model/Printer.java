package racingcar.model;

import racingcar.StringUtils;

public class Printer {

  public void printReadCarNames() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
  }

  public void printReadRoundsToPlays() {
    System.out.println("시도할 회수는 몇회인가요?");
  }

  public void printExecutionResultMessage() {
    System.out.println("실행 결과");
  }

  public void printExecutionResult(Cars cars) {
    System.out.println("실행 결과");
    cars.forEach(this::printExecutionResultRow);
    System.out.println();
  }

  private void printExecutionResultRow(Car car) {
    System.out.printf("%s : %s\n", car.getName(), StringUtils.repeat("-", car.getPosition()));
  }

  public void printWinners(Cars cars) {
    System.out.printf("최종 우승자 : %s\n", cars.filterWinners().toString());
  }

  public void printError(Exception e) {
    System.out.printf("[ERROR] %s\n", e.getMessage());
  }
}
