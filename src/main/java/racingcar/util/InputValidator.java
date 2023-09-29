package racingcar.util;

import java.util.regex.Pattern;

public final class InputValidator {

  private static final String CAR_NAMES_PATTERN = "^\\w+(,\\w+)*$";

  public void validateCarNamesInput(final String input) {
    if (!Pattern.matches(CAR_NAMES_PATTERN, input)) {
      throw new IllegalArgumentException("유효하지 않은 입력입니다. 자동차 이름은 pobi,woni,jun과 같이 ,로 구분되어야 합니다.");
    }
  }


}
