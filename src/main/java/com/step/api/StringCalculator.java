package com.step.api;

import java.util.Arrays;
import org.springframework.util.ObjectUtils;

public class StringCalculator {

  public int calculator(String stringParam) {
    // 빈 문자열 또는 null 값을 입력할 경우 0 반환
    if (ObjectUtils.isEmpty(stringParam)) {
      return 0;
    }

    // 숫자가 하나 입력될 경우 해당 숫자 리턴
    if (stringParam.length() == 1) {
      return Integer.parseInt(stringParam);
    }

    int result = 0;
    if (stringParam.contains(",") || stringParam.contains(":")) {
      result = Arrays.stream(stringParam.split(",|:")).mapToInt(Integer::parseInt).sum();
    }

    if (stringParam.contains("//") && stringParam.contains("\n")) {
      result = Arrays.stream(getNumArrayList(stringParam)).sum();
    }

    // 음수를 전달하는 경우 예외처리
    if (result < 0) {
      throw new RuntimeException();
    }
    return result;
  }

  public int[] getNumArrayList(String includedDelimiterString) {
    String excludeDelimiter = getDelimiter(includedDelimiterString);
    return Arrays.stream(getExcludeDelimiterString(includedDelimiterString).split(excludeDelimiter))
        .mapToInt(Integer::parseInt).toArray();
  }

  public String getExcludeDelimiterString(String includedDelimiterString) {
    return includedDelimiterString.substring(includedDelimiterString.lastIndexOf('\n') + 1);
  }

  public String getDelimiter(String includedDelimiterString) {
    return includedDelimiterString.substring(
        includedDelimiterString.lastIndexOf("/") + 1,
        includedDelimiterString.indexOf('\n'));
  }
}
