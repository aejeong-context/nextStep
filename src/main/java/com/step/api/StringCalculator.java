package com.step.api;

import java.util.Arrays;

public class StringCalculator {

  public int calculator(String stringParam) {
    int[] numArrayList = getNumArrayList(stringParam);
    return Arrays.stream(numArrayList).sum();
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
