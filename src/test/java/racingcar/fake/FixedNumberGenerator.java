package racingcar.fake;

import racingcar.util.NumberGenerator;

public final class FixedNumberGenerator implements NumberGenerator {

  private final int number;

  public FixedNumberGenerator(final int number) {
    this.number = number;
  }

  @Override
  public int generate() {
    return number;
  }
}
