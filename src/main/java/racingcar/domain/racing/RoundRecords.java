package racingcar.domain.racing;

import java.util.List;
import java.util.stream.Collectors;

public abstract class RoundRecords {

  protected final List<RoundRecord> roundRecords;

  protected RoundRecords(final List<RoundRecord> roundRecords) {
    this.roundRecords = roundRecords;
  }

//  public static RoundRecords from(final Cars cars) {
//    final List<RoundRecord> roundRecords = new ArrayList<>();
//    for (final Car car : cars.getCars()) {
//      roundRecords.add(RoundRecord.from(car));
//    }
//    return new RoundRecords(roundRecords);
//  }

  @Override
  public String toString() {
    return roundRecords.stream()
        .map(RoundRecord::toString)
        .collect(Collectors.joining("\n"));
  }

  public List<RoundRecord> getWinningRecords() {
    return roundRecords.stream()
        .sorted((o1, o2) -> o2.getPosition() - o1.getPosition())
        .collect(Collectors.toList());
  }
}
