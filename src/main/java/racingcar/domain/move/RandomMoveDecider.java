package racingcar.domain.move;

import racingcar.util.NumberGenerator;

public final class RandomMoveDecider implements MoveDecider {

  private final int minMoveNumber;
  private final NumberGenerator numberGenerator;

  public RandomMoveDecider(
      final int minMoveNumber,
      final NumberGenerator numberGenerator
  ) {
    this.minMoveNumber = minMoveNumber;
    this.numberGenerator = numberGenerator;
  }

  @Override
  public boolean canMove() {
    final int number = numberGenerator.generate();
    return number >= minMoveNumber;
  }
}
