package com.gcipriano.katas.model.product;

import com.gcipriano.katas.model.taxing.TaxExemptStrategy;
import org.junit.Before;
import org.junit.Test;

import static java.math.BigDecimal.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TaxExemptStrategyTest
{
  private TaxExemptStrategy taxExemptStrategy;

  @Before
  public void setUp() throws Exception
  {
    taxExemptStrategy = new TaxExemptStrategy();
  }

  @Test
  public void shouldReturnSameAmount() throws Exception
  {
    assertThat(taxExemptStrategy.applyOn(ZERO), is(ZERO));
    assertThat(taxExemptStrategy.applyOn(ONE), is(ONE));
    assertThat(taxExemptStrategy.applyOn(TEN), is(TEN));
  }
}