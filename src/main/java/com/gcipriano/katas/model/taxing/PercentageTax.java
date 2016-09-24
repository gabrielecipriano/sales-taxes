package com.gcipriano.katas.model.taxing;

import com.gcipriano.katas.model.product.Tax;

import java.math.BigDecimal;

public class PercentageTax implements Tax
{
  private static final BigDecimal ONE_HUNDRED = new BigDecimal("100");

  private final BigDecimal percentageTaxAmount;

  public PercentageTax(int percentageAmount)
  {
    percentageTaxAmount = new BigDecimal(percentageAmount);
  }

  @Override public BigDecimal applyOn(BigDecimal amount)
  {
    return amount.multiply(percentageTaxAmount).divide(ONE_HUNDRED);
  }
}
