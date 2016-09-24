package com.gcipriano.katas.model.product;

import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AppliableStrategyProductTest
{
  private AppliableStrategy appliableStrategy = new DummyAppliableStrategy();

  @Test
  public void applyStrategy() throws Exception
  {
    AppliableStrategyProduct product = new AppliableStrategyProduct(null, "2.2", appliableStrategy);

    assertThat(product.taxAmount(), is(new BigDecimal("3.2")));
  }

  @Test
  public void nameAndAmount() throws Exception
  {
    AppliableStrategyProduct product = new AppliableStrategyProduct("NAME", "2.2", null);

    assertThat(product.amount(), is(new BigDecimal("2.2")));
    assertThat(product.description(), is("NAME"));
  }

  private class DummyAppliableStrategy implements AppliableStrategy
  {
    @Override public BigDecimal applyOn(BigDecimal amount)
    {
      return amount.add(ONE);
    }
  }
}