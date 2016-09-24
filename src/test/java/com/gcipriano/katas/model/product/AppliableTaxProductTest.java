package com.gcipriano.katas.model.product;

import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AppliableTaxProductTest
{
  private Tax tax = new DummyTax();

  @Test
  public void applyStrategy() throws Exception
  {
    AppliableTaxProduct product = new AppliableTaxProduct(null, "2.2", tax);

    assertThat(product.taxAmount(), is(new BigDecimal("3.2")));
  }

  @Test
  public void nameAndAmount() throws Exception
  {
    AppliableTaxProduct product = new AppliableTaxProduct("NAME", "2.2", null);

    assertThat(product.amount(), is(new BigDecimal("2.2")));
    assertThat(product.description(), is("NAME"));
  }

  private class DummyTax implements Tax
  {
    @Override public BigDecimal applyOn(BigDecimal amount)
    {
      return amount.add(ONE);
    }
  }
}