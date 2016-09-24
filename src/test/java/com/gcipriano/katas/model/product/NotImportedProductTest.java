package com.gcipriano.katas.model.product;

import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class NotImportedProductTest
{
  private Tax tax = new PlusOneTax();

  @Test
  public void applyStrategy() throws Exception
  {
    NotImportedProduct product = new NotImportedProduct("2.2", null, tax);

    assertThat(product.taxAmount(), is(new BigDecimal("3.20")));
  }

  @Test
  public void nameAndAmount() throws Exception
  {
    NotImportedProduct product = new NotImportedProduct("2.2", "NAME", null);

    assertThat(product.amount(), is(new BigDecimal("2.2")));
    assertThat(product.description(), is("NAME"));
  }

  private class PlusOneTax implements Tax
  {
    @Override public BigDecimal applyOn(BigDecimal amount)
    {
      return amount.add(ONE);
    }
  }
}