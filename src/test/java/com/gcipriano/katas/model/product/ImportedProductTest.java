package com.gcipriano.katas.model.product;

import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ImportedProductTest
{
  @Test
  public void applyAdditionFivePercentOnTax() throws Exception
  {
    ImportedProduct importedProduct = new ImportedProduct(new FixedAmountsProduct(new BigDecimal("100"),
                                                                                  new BigDecimal("10")));

    assertThat(importedProduct.taxAmount(), is(new BigDecimal("15.00")));
  }

  @Test
  public void applyFivePercent() throws Exception
  {
    ImportedProduct importedProduct = new ImportedProduct(new FixedAmountsProduct(new BigDecimal("11.25"),
                                                                                  ZERO));

    assertThat(importedProduct.taxAmount(), is(new BigDecimal("0.60")));
  }
}