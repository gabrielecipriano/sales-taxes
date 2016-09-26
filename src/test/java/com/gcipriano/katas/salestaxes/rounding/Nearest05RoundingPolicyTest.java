package com.gcipriano.katas.salestaxes.rounding;

import com.gcipriano.katas.salestaxes.rounding.Nearest05RoundingPolicy;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Nearest05RoundingPolicyTest
{

  private final Nearest05RoundingPolicy roundingPolicy;

  public Nearest05RoundingPolicyTest()
  {
    roundingPolicy = new Nearest05RoundingPolicy();
  }

  @Test
  public void roundingExamples() throws Exception
  {
    assertThat(roundingPolicy.round(new BigDecimal("0.06")), is(new BigDecimal("0.10")));
    assertThat(roundingPolicy.round(new BigDecimal("1.04")), is(new BigDecimal("1.05")));
    assertThat(roundingPolicy.round(new BigDecimal("13.644675")), is(new BigDecimal("13.65")));
    assertThat(roundingPolicy.round(new BigDecimal("0.0000011")), is(new BigDecimal("0.05")));
  }
}