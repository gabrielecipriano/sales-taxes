package com.gcipriano.katas.model.taxing;

import com.gcipriano.katas.model.product.Tax;

import java.math.BigDecimal;

import static java.math.BigDecimal.TEN;

public class TenPercent implements Tax
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
