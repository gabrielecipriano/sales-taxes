package com.gcipriano.katas.model;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;

public class TenPercentTaxedProduct implements Product
{
  private final String description;
  private BigDecimal amount;

  public TenPercentTaxedProduct(String amount, String description)
  {
    this.amount = new BigDecimal(amount);
    this.description = description;
  }

  @Override public BigDecimal taxAmount()
  {
    return tenPercent();
  }

  @Override public BigDecimal amount()
  {
    return amount;
  }

  @Override public String description()
  {
    return description;
  }

  private BigDecimal tenPercent()
  {
    return round(amount.multiply(new BigDecimal(10)).divide(new BigDecimal(100)));
  }

  private BigDecimal round(BigDecimal toRound)
  {
    return new BigDecimal(Math.round(toRound.doubleValue() * 20) / 20.0).setScale(2, ROUND_HALF_UP);
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    TenPercentTaxedProduct tenPercentTaxedProduct = (TenPercentTaxedProduct) o;

    return amount != null ? amount.equals(tenPercentTaxedProduct.amount) : tenPercentTaxedProduct.amount == null;

  }

  @Override public int hashCode()
  {
    return amount != null ? amount.hashCode() : 0;
  }

  @Override public String toString()
  {
    return "TenPercentTaxedProduct{" +
        "amount=" + amount +
        '}';
  }
}
