package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

  private final InputValidator inputValidator = new InputValidator();

  @DisplayName("자동차 이름은 콤마(,)로 나눠져야 한다.")
  @Test
  void inputCarNamesSeperatedByCommas() {
    // given
    final String input = "aaa,bbb,ccc";

    // when then
    inputValidator.validateCarNamesInput(input);
  }

  @DisplayName("자동차 이름이 콤마(,) 외의 문자로 나눠지면 예외 발생")
  @Test
  void inputCarNamesSeperatedByOthers() {
    // given
    final String input = "aaa,bbb#ccc";

    // when then
    assertThatThrownBy(
        () -> inputValidator.validateCarNamesInput(input)
    )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("유효하지 않은 입력입니다. 자동차 이름은 pobi,woni,jun과 같이 ,로 구분되어야 합니다.");

  }

  @DisplayName("최대 라운드 횟수로 숫자로만 이루어진 문자열을 입력 받을 수 있다.")
  @Test
  void inputMaxRacingRoundAsNumberString() {
    // given
    final String input = "1";

    // when then
    inputValidator.validateMaxRacingRoundInput(input);
  }

  @DisplayName("최대 라운드 횟수로 숫자 외의 문자가 포함된 문자열을 입력 받으면 예외가 발생한다.")
  @Test
  void inputMaxRacingRoundAsNotNumberString() {
    // given
    final String input = "1x1";

    // when then
    assertThatThrownBy(
        () -> inputValidator.validateMaxRacingRoundInput(input)
    )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("시도 횟수는 숫자여야 한다.");
  }
}