package com.gcipriano.katas.model;

import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TaxExemptedProductTest
{
  @Test
  public void noTaxes() throws Exception
  {
    assertThat(new TaxExemptedProduct("10", "").taxAmount(), is(ZERO));
    assertThat(new TaxExemptedProduct("10", "").amount(), is(new BigDecimal(10)));
    assertThat(new TaxExemptedProduct("10", "NAME").description(), is("NAME"));
  }
}