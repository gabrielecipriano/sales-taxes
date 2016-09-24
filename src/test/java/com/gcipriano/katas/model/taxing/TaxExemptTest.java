package com.gcipriano.katas.model.taxing;

import com.gcipriano.katas.model.taxing.TaxExempt;
import org.junit.Before;
import org.junit.Test;

import static java.math.BigDecimal.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TaxExemptTest
{
  private TaxExempt taxExempt;

  @Before
  public void setUp() throws Exception
  {
    taxExempt = new TaxExempt();
  }

  @Test
  public void shouldReturnZero() throws Exception
  {
    assertThat(taxExempt.applyOn(ZERO), is(ZERO));
    assertThat(taxExempt.applyOn(ONE), is(ZERO));
    assertThat(taxExempt.applyOn(TEN), is(ZERO));
  }
}