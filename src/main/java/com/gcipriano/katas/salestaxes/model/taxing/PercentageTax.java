package com.gcipriano.katas.salestaxes.model.taxing;

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

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    PercentageTax that = (PercentageTax) o;

    return percentageTaxAmount.equals(that.percentageTaxAmount);

  }

  @Override public int hashCode()
  {
    return percentageTaxAmount.hashCode();
  }

  @Override public String toString()
  {
    return "PercentageTax{" +
        "percentageTaxAmount=" + percentageTaxAmount +
        '}';
  }
}
