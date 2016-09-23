package com.gcipriano.katas.model;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ImportedProductTest
{
  @Test
  public void applyAdditionFivePercentOnTax() throws Exception
  {
    ImportedProduct importedProduct = new ImportedProduct(new FakeProduct());

    assertThat(importedProduct.taxAmount(), is(new BigDecimal("15")));
  }

  private class FakeProduct implements Product
  {
    @Override public BigDecimal taxAmount()
    {
      return new BigDecimal("10");
    }

    @Override public BigDecimal amount()
    {
      return new BigDecimal("100");
    }
  }
}