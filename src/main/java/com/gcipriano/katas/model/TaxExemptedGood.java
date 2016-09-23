package com.gcipriano.katas.model;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public class TaxExemptedGood implements Product
{
  private final String description;
  private BigDecimal amount;

  public TaxExemptedGood(String amount, String description)
  {
    this.amount = new BigDecimal(amount);
    this.description = description;
  }

  @Override public BigDecimal taxAmount()
  {
    return ZERO;
  }

  @Override public BigDecimal amount()
  {
    return amount;
  }

  @Override public String description()
  {
    return description;
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    TaxExemptedGood that = (TaxExemptedGood) o;

    return amount != null ? amount.equals(that.amount) : that.amount == null;

  }

  @Override public int hashCode()
  {
    return amount != null ? amount.hashCode() : 0;
  }

  @Override public String toString()
  {
    return "TaxExemptedGood{" +
        "amount=" + amount +
        '}';
  }
}
