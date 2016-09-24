package com.gcipriano.katas.model.taxing;

import com.gcipriano.katas.model.product.Tax;
import org.junit.Test;

import static com.gcipriano.katas.model.taxing.TaxingStrategy.*;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TaxingStrategyTest
{
  @Test
  public void exempt() throws Exception
  {
    assertThat(TAX_EXEMPT.tax(), is(instanceOf(TaxExempt.class)));
  }

  @Test
  public void tenPercent() throws Exception
  {
    assertThat(TEN_PERCENT.tax(), is(instanceOf(PercentageTax.class)));
  }
}