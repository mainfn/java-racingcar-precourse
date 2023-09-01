package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public final class GameController {

  private final OutputView outputView;
  private final InputView inputView;

  public GameController(
      final OutputView outputView,
      final InputView inputView
  ) {
    this.outputView = outputView;
    this.inputView = inputView;
  }

  // controller/GameController.java
  public void start() {
    // 1. Cars를 받아옴
    final Cars cars = inputView.inputCars();

    // 3. 진행할 라운드 받아옴
    final int maxRound = inputView.inputMaxRound();

    // 4. 게임 시작

    // 5. 결과 출력
  }
}
