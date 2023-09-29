package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

  @DisplayName("차의 최초 위치는 0이며, move 할 때마다 1씩 증가한다.")
  @Test
  void move() {
    // given
    final Car car1 = Car.of("a");
    final Car car2 = Car.of("b");

    // when
    car2.move();

    // then
    assertThat(car1.getPosition()).isEqualTo(0);
    assertThat(car1.getName()).isEqualTo("a");

    assertThat(car2.getPosition()).isEqualTo(1);
  }


  @DisplayName("차 생성 시, 이름이 빈 문자열이거나 null인 경우 예외 발생")
  @Test
  void carNameMustNotBeNull() {
    // given
    // when
    // then
    assertThatThrownBy(
        () -> Car.of("")
    )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("차 이름을 입력해주세요.");
    assertThatThrownBy(
        () -> Car.of(null)
    )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("차 이름을 입력해주세요.");
  }

  @DisplayName("차 이름이 5자 초과 시 예외 발생")
  @Test
  void carNameShorterThanOneOrLongerThanFive() {
    // given
    // when
    // then
    assertThatThrownBy(
        () -> Car.of("123456")
    )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("차 이름은 5자 이하만 가능합니다.");
  }


  @DisplayName("차 이름이 1자 이상 5자 이하인 경우 생성 가능")
  @Test
  void carNameEqualsToOneOrLongerThanOneOrEqualsOrLessThanFive() {
    // given
    final String carName1 = "a";
    final String carName2 = "abcde";

    // when
    final Car car1 = Car.of(carName1);
    final Car car2 = Car.of(carName2);

    // then
    assertThat(car1.getName()).isEqualTo(carName1);
    assertThat(car1.getPosition()).isZero();

    assertThat(car2.getName()).isEqualTo(carName2);
    assertThat(car2.getPosition()).isZero();
  }
}