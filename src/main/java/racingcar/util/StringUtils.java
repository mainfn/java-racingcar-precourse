package racingcar.util;

public final class StringUtils {

  public static String repeat(final String ch, final int count) {
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < count; i++) {
      sb.append(ch);
    }
    return sb.toString();
  }
}
