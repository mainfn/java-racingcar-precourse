package racingcar.domain.racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public final class PlayingRoundRecord extends RoundRecords {

  private PlayingRoundRecord(final List<RoundRecord> roundRecords) {
    super(roundRecords);
  }

  public static PlayingRoundRecord from(final Cars cars) {
    final List<RoundRecord> roundRecords = new ArrayList<>();
    for (final Car car : cars.getCars()) {
      roundRecords.add(RoundRecord.from(car));
    }
    return new PlayingRoundRecord(roundRecords);
  }

  public CompletedRoundRecords intoCompletedRoundRecords() {
    return new CompletedRoundRecords(roundRecords);
  }

  @Override
  public String toString() {
    return roundRecords.stream()
        .map(RoundRecord::toString)
        .collect(Collectors.joining("\n"));
  }
}
