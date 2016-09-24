package com.gcipriano.katas.model.taxing;

import com.gcipriano.katas.model.product.AppliableStrategy;

import java.math.BigDecimal;

import static java.math.BigDecimal.TEN;

public class TaxOfTenPercentStrategy implements AppliableStrategy
{
  private static final BigDecimal ONE_HUNDRED = new BigDecimal("100");

  @Override public BigDecimal applyOn(BigDecimal amount)
  {
    return tenPercentOn(amount);
  }

  private BigDecimal tenPercentOn(BigDecimal amount)
  {
    return amount.multiply(TEN).divide(ONE_HUNDRED);
  }
}
