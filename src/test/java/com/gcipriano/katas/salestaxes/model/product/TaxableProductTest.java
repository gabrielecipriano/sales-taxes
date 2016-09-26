package com.gcipriano.katas.salestaxes.model.product;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TaxableProductTest
{
  @Test
  public void nameAndAmount() throws Exception
  {
    TaxableProduct product = new TaxableProduct("2.2", "NAME");

    assertThat(product.amount(), is(new BigDecimal("2.2")));
    assertThat(product.description(), is("NAME"));
  }
}