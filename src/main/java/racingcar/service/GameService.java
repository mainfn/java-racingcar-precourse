package racingcar.service;

import racingcar.domain.Cars;

public final class GameService {

  public void play(
      final Cars cars,
      final int maxRound
  ) {
    cars.moveAllRounds(maxRound);
  }

}
