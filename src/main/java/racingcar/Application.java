package racingcar;

import racingcar.controller.GameController;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

  public static void main(final String[] args) {
    final OutputView outputView = new OutputView();
    final InputView inputView = new InputView(outputView);
    final GameService gameService = new GameService();
    final GameController gameController = new GameController(outputView, inputView, gameService);

    try {
      gameController.start();
    } catch (final Exception e) {
      System.out.printf("[ERROR] %s\n", e.getMessage());
    }
  }
}
