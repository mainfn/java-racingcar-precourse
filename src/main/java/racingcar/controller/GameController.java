package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public final class GameController {

  private final OutputView outputView;
  private final InputView inputView;
  private final GameService gameService;

  public GameController(
      final OutputView outputView,
      final InputView inputView,
      final GameService gameService
  ) {
    this.outputView = outputView;
    this.inputView = inputView;
    this.gameService = gameService;
  }

  public void start() {
    // 1. Cars를 받아옴
    final Cars cars = inputView.inputCars();

    // 2. 진행할 라운드 받아옴
    final int maxRound = inputView.inputMaxRound();

    // 3. 게임 시작
    gameService.play(cars, maxRound);

    // 4. 결과 출력
    outputView.printGameResult(cars.into());
  }
}
