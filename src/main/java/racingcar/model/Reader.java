package racingcar.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.exception.InvalidRoundsToPlayException;

public class Reader {

  public List<String> readCarNames() {
    return Arrays.stream(Console
            .readLine()
            .split(","))
        .collect(Collectors.toList());
  }

  public int readRoundsToPlay() {
    try {
      return Integer.parseInt(Console.readLine().trim());
    } catch (Exception e) {
      throw new InvalidRoundsToPlayException();
    }
  }
}
