package racingcar.fake;

import racingcar.domain.move.MoveDecider;

public final class FixedMoveDecider implements MoveDecider {

  private final boolean movable;


  public FixedMoveDecider(final boolean movable) {
    this.movable = movable;
  }

  @Override
  public boolean canMove() {
    return movable;
  }
}
