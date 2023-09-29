package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.move.MoveDecider;
import racingcar.fake.FixedMoveDecider;

class CarsTest {

  @DisplayName("차 이름 List를 받아 Cars 생성 가능")
  @Test
  void createCarsFromCarNames() {
    // given
    final List<String> carNames = Arrays.asList("a", "b", "c");

    // when
    final Cars cars = Cars.from(carNames);

    // then
    assertThat(cars).isNotNull();
  }

  @DisplayName("MoveDecider가 true를 반환하면 Cars 내의 모든 Car의 position을 증가시킴")
  @Test
  void moveCarsWhenMoveDeciderReturnsTrue() {
    // given
    final Cars cars = Cars.from(Arrays.asList("a", "b", "c"));
    final MoveDecider trueMoveDecider = new FixedMoveDecider(true);

    // when
    cars.moveCarsBy(trueMoveDecider);

    // then
    assertThat(cars.getCars()).hasSize(3)
        .extracting("name", "position")
        .containsExactlyInAnyOrder(
            tuple("a", 1),
            tuple("b", 1),
            tuple("c", 1)
        );

  }

  @DisplayName("MoveDecider가 false를 반환하면 Cars 내의 모든 Car의 position은 변화 없음")
  @Test
  void moveCarsWhenMoveDeciderReturnsFalse() {
    // given
    final Cars cars = Cars.from(Arrays.asList("a", "b", "c"));
    final MoveDecider falseMoveDecider = new FixedMoveDecider(false);

    // when
    cars.moveCarsBy(falseMoveDecider);

    // then
    assertThat(cars.getCars()).hasSize(3)
        .extracting("name", "position")
        .containsExactlyInAnyOrder(
            tuple("a", 0),
            tuple("b", 0),
            tuple("c", 0)
        );

  }
}