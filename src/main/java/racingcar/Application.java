package racingcar;

import racingcar.controller.GameController;
import racingcar.domain.move.MoveDecider;
import racingcar.domain.move.RandomMoveDecider;
import racingcar.util.InputValidator;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public final class Application {

  public static void main(final String[] args) {
    final InputValidator inputValidator = new InputValidator();
    final OutputView outputView = new OutputView();
    final InputView inputView = new InputView(inputValidator, outputView);
    final NumberGenerator randomNumberGenerator = new RandomNumberGenerator(0, 9);
    final MoveDecider randomMoveDecider = new RandomMoveDecider(4, randomNumberGenerator);
    final GameController gameController = new GameController(inputView, outputView,
        randomMoveDecider);

    try {
      gameController.run();
    } catch (final Exception e) {
      System.out.println("[ERROR]" + e.getMessage());
    }
  }

}
