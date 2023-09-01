package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public final class InputView {

  private final OutputView outputView;

  public InputView(final OutputView outputView) {
    this.outputView = outputView;
  }

  public Cars inputCars() {
    outputView.printInputCarNamesMessage();

    final List<String> carNames = Arrays.stream(readLine()
            .split(","))
        .collect(Collectors.toList());

    return Cars.from(carNames);
  }

  public Integer inputMaxRound() {
    outputView.printInputMaxRoundMessage();

    return Integer.parseInt(readLine());
  }

  private String readLine() {
    return Console.readLine().trim();
  }
}
