package racingcar.domain.move;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.fake.FixedNumberGenerator;
import racingcar.util.NumberGenerator;

class RandomMoveDeciderTest {

  @DisplayName("생성된 숫자가 minMoveNumber와 같은 경우 움직일 수 있다.")
  @Test
  void canMoveIfNumberIsGreaterThanMinMoveNumber() {
    // given
    final NumberGenerator fixedNumberGenerator = new FixedNumberGenerator(4);
    final MoveDecider moveDecider = new RandomMoveDecider(4, fixedNumberGenerator);

    // when
    boolean canMove = moveDecider.canMove();

    // then
    assertThat(canMove).isTrue();

  }

  @DisplayName("생성된 숫자가 minMoveNumber보다 큰 경우 움직일 수 있다.")
  @Test
  void canMoveIfNumberEqualsToMinMoveNumber() {
    // given
    final NumberGenerator fixedNumberGenerator = new FixedNumberGenerator(5);
    final MoveDecider moveDecider = new RandomMoveDecider(4, fixedNumberGenerator);

    // when
    boolean canMove = moveDecider.canMove();

    // then
    assertThat(canMove).isTrue();

  }

  @DisplayName("생성된 숫자가 minMoveNumber보다 작은 경우 움직일 수 있다.")
  @Test
  void canMoveIfNumberIsLessThanMinMoveNumber() {
    // given
    final NumberGenerator fixedNumberGenerator = new FixedNumberGenerator(3);
    final MoveDecider moveDecider = new RandomMoveDecider(4, fixedNumberGenerator);

    // when
    boolean canMove = moveDecider.canMove();

    // then
    assertThat(canMove).isFalse();

  }
}