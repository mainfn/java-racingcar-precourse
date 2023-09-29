package racingcar.view;

import racingcar.domain.racing.CompletedRoundRecords;
import racingcar.domain.racing.PlayingRoundRecord;

public final class OutputView {

  public void printInputCarNamesMessage() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
  }

  public void printInputAttemptCount() {
    System.out.println("시도할 회수는 몇회인가요?");
  }

  public void printGameWinners(final CompletedRoundRecords completedRoundRecords) {
    System.out.println(completedRoundRecords);
  }

  public void printRoundResult(final PlayingRoundRecord playingRoundRecord) {
    System.out.println("실행 결과");
    System.out.println(playingRoundRecord);
    System.out.println();
  }
}
