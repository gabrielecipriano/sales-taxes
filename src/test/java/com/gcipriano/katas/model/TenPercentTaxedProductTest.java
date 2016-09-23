package com.gcipriano.katas.model;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TenPercentTaxedProductTest
{
  @Test
  public void tenPercentTax() throws Exception
  {
    assertThat(new TenPercentTaxedProduct("14.99", "").taxAmount(), is(new BigDecimal("1.50")));
    assertThat(new TenPercentTaxedProduct("33.30", "").taxAmount(), is(new BigDecimal("3.35")));
    assertThat(new TenPercentTaxedProduct("21.20", "").taxAmount(), is(new BigDecimal("2.10")));
    assertThat(new TenPercentTaxedProduct("10", "music CD").amount(), is(new BigDecimal("10")));
    assertThat(new TenPercentTaxedProduct("10", "NAME").description(), is("NAME"));
  }
}