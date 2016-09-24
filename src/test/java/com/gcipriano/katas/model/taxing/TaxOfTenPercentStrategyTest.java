package com.gcipriano.katas.model.taxing;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.TEN;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TaxOfTenPercentStrategyTest
{
  private TaxOfTenPercentStrategy tenPercent;

  @Before
  public void setUp() throws Exception
  {
    tenPercent = new TaxOfTenPercentStrategy();
  }

  @Test
  public void tenPercent() throws Exception
  {
    assertThat(tenPercent.applyOn(TEN), is(ONE));
    assertThat(tenPercent.applyOn(new BigDecimal("11")), is(new BigDecimal("1.1")));
    assertThat(tenPercent.applyOn(new BigDecimal("4321")), is(new BigDecimal("432.1")));
  }
}