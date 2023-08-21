package racingcar;

public class StringUtils {

  public static String repeat(String str, int count) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < count; i++) {
      stringBuilder.append(str);
    }
    return stringBuilder.toString();
  }
}
