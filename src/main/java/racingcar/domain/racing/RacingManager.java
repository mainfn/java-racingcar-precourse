package racingcar.domain.racing;

import racingcar.domain.car.Cars;
import racingcar.domain.move.MoveDecider;

public final class RacingManager {

  private final Cars cars;

  private final MoveDecider moveDecider;

  private final int maxRacingRound;

  public RacingManager(
      final Cars cars,
      final MoveDecider moveDecider,
      final int maxRacingRound
  ) {
    this.cars = cars;
    this.moveDecider = moveDecider;
    this.maxRacingRound = maxRacingRound;
  }

  public PlayingRoundRecord playRound() {
    cars.moveCarsBy(moveDecider);
    return PlayingRoundRecord.from(cars);
  }

  public int getMaxRacingRound() {
    return maxRacingRound;
  }
}
