package com.step.api;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

  static StringCalculator stringCalculator;
  final String testString = "\\/\\/:\n1:3:1";

  @BeforeAll
  public static void setup() {
    stringCalculator = new StringCalculator();
  }

  @Test
  void calculator() {
    int calculated = stringCalculator.calculator(testString);
    assertThat(calculated).isEqualTo(5);
  }

  @Test
  void getNumArrayList() {
    int[] numArrayList = stringCalculator.getNumArrayList(testString);
    assertThat(numArrayList).contains(1, 3, 1);
  }

  @Test
  void getExcludeDelimiterString() {
    String excludeDelimiterString = stringCalculator.getExcludeDelimiterString(testString);
    assertThat(excludeDelimiterString).isEqualTo("1:3:1");
  }

  @Test
  void getExcludeDelimiter() {
    String delimiter = stringCalculator.getDelimiter("\\/\\/:\n");
    assertThat(delimiter).isEqualTo(":");
  }

}