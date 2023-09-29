package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.InputValidator;

public final class InputView {

  private final InputValidator inputValidator;
  private final OutputView outputView;

  public InputView(
      final InputValidator inputValidator,
      final OutputView outputView
  ) {
    this.inputValidator = inputValidator;
    this.outputView = outputView;
  }

  public List<String> inputCarNames() {
    outputView.printInputCarNamesMessage();
    final String input = readLine();
    inputValidator.validateCarNamesInput(input);

    return Arrays.stream(input.split(","))
        .collect(Collectors.toList());
  }

  public int inputMaxRacingRound() {
    outputView.printInputAttemptCount();
    final String input = readLine();
    inputValidator.validateMaxRacingRoundInput(input);

    return Integer.parseInt(input);
  }

  private String readLine() {
    return Console.readLine().trim();
  }
}
