package com.gcipriano.katas.model;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public class ChocolateBar implements Product
{
  private BigDecimal amount;

  public ChocolateBar(String amount)
  {
    this.amount = new BigDecimal(amount);
  }

  @Override public BigDecimal taxAmount()
  {
    return ZERO;
  }

  @Override public BigDecimal amount()
  {
    return amount;
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    ChocolateBar that = (ChocolateBar) o;

    return amount != null ? amount.equals(that.amount) : that.amount == null;

  }

  @Override public int hashCode()
  {
    return amount != null ? amount.hashCode() : 0;
  }

  @Override public String toString()
  {
    return "ChocolateBar{" +
        "amount=" + amount +
        '}';
  }
}
