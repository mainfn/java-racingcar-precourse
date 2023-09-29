package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.move.MoveDecider;
import racingcar.domain.racing.CompletedRoundRecords;
import racingcar.domain.racing.PlayingRoundRecord;
import racingcar.domain.racing.RacingManager;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public final class GameController {

  private final InputView inputView;
  private final OutputView outputView;
  private final MoveDecider moveDecider;


  public GameController(
      final InputView inputView,
      final OutputView outputView,
      final MoveDecider moveDecider
  ) {
    this.inputView = inputView;
    this.outputView = outputView;
    this.moveDecider = moveDecider;
  }

  public void run() {
    // 1. 데이터 입력
    final RacingManager racingManager = createRacingManager(moveDecider);

    // 2. 게임 실행
    final CompletedRoundRecords completedRoundRecords = playGame(racingManager);

    // 3. 결과 출력
    printResult(completedRoundRecords);
  }

  private RacingManager createRacingManager(final MoveDecider moveDecider) {
    final Cars cars = Cars.from(inputView.inputCarNames());
    final int maxRacingRound = inputView.inputMaxRacingRound();

    return new RacingManager(cars, moveDecider, maxRacingRound);
  }

  private CompletedRoundRecords playGame(final RacingManager racingManager) {
    PlayingRoundRecord roundRecords = null;
    for (int i = 0; i < racingManager.getMaxRacingRound(); i++) {
      roundRecords = racingManager.playRound();
      outputView.printRoundResult(roundRecords);
    }
    return roundRecords.intoCompletedRoundRecords();
  }

  private void printResult(final CompletedRoundRecords completedRoundRecords) {
    outputView.printGameWinners(completedRoundRecords);
  }
}
