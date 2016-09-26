package com.gcipriano.katas.salestaxes.model.taxing;

import com.gcipriano.katas.salestaxes.model.taxing.PercentageTax;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PercentageTaxTest
{
  @Test
  public void fivePercent() throws Exception
  {
    assertThat(new PercentageTax(5).applyOn(new BigDecimal("100")), is(new BigDecimal("5")));
    assertThat(new PercentageTax(1).applyOn(new BigDecimal("10")), is(new BigDecimal("0.1")));
    assertThat(new PercentageTax(3).applyOn(new BigDecimal("90")), is(new BigDecimal("2.7")));
  }
}