package racingcar.domain.racing;

import java.util.List;
import java.util.stream.Collectors;

public final class CompletedRoundRecords extends RoundRecords {

  public CompletedRoundRecords(final List<RoundRecord> roundRecords) {
    super(roundRecords);
  }

  @Override
  public String toString() {
    return "최종 우승자 : " + getWinnerNames();
  }

  private String getWinnerNames() {

    return roundRecords
        .stream()
        .map(RoundRecord::getCarName)
        .collect(Collectors.joining(", "));
  }

  private int getMaxPosition() {
    return roundRecords.stream()
        .mapToInt(RoundRecord::getPosition)
        .max()
        .getAsInt();
  }
}
