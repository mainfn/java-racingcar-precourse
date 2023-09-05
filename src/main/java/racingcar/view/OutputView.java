package racingcar.view;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.model.GameResult;

public final class OutputView {

  public void printInputCarNamesMessage() {
    System.out.println(Message.INPUT_CAR_NAMES);
  }

  public void printInputMaxRoundMessage() {
    System.out.println(Message.INPUT_MAX_ROUND);
  }

  public void printGameResult(final GameResult gameResult) {
    final List<Car> cars = gameResult.getCars();
    System.out.println();
    System.out.println("실행 결과");
    printRoundResults(cars);
    printWinners(cars);
  }

  private void printRoundResults(final List<Car> cars) {

    final int maxRound = cars.get(0).getPositionsByRound().size();

    for (int roundIndex = 0; roundIndex < maxRound; roundIndex++) {
      for (final Car car : cars) {
        final String name = car.getName();
        final Integer position = car.getPositionsByRound().get(roundIndex);
        System.out.printf("%s : %s\n", name, repeatDashes(position));
      }
      System.out.println();
    }
  }

  private void printWinners(final List<Car> cars) {

    final Integer maxPosition = cars.stream()
        .map(Car::getLastPosition)
        .max(Comparator.comparingInt(a -> a))
        .orElseThrow(IllegalStateException::new);

    final String winnerNames = cars.stream()
        .filter(car -> car.getLastPosition().equals(maxPosition))
        .map(Car::getName)
        .collect(Collectors.joining(", "));

    System.out.printf("최종 우승자 : %s\n", winnerNames);
  }

  private String repeatDashes(final int count) {
    final StringBuilder sb = new StringBuilder();

    for (int i = 0; i < count; i++) {
      sb.append("-");
    }
    return sb.toString();
  }

}
