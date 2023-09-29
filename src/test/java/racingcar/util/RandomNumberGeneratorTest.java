package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

  void generateRandomNumber() {
    // given
    final int startInclusive = 0;
    final int endInclusive = 100;
    final NumberGenerator randomNumberGenerator = new RandomNumberGenerator(startInclusive,
        endInclusive);

    // when
    final int generatedRandomNumber = randomNumberGenerator.generate();

    // then
    assertThat(generatedRandomNumber).isGreaterThanOrEqualTo(startInclusive);
    assertThat(generatedRandomNumber).isLessThanOrEqualTo(endInclusive);
  }

  @DisplayName("임의 생성된 숫자는 start 이상 end 이하의 범위를 갖는다.")
  @Test
  void generateRandomNumberManyTimes() {
    for (int i = 0; i < 1_000_000; i++) {
      generateRandomNumber();
    }
  }
}