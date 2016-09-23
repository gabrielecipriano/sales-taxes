package com.gcipriano.katas.model;

import java.math.BigDecimal;

public class MusicCD implements Product
{
  private BigDecimal amount;

  public MusicCD(String amount)
  {
    this.amount = new BigDecimal(amount);
  }

  @Override public BigDecimal taxAmount()
  {
    return tenPercent();
  }

  @Override public BigDecimal amount()
  {
    return amount;
  }

  private BigDecimal tenPercent()
  {
    return amount.multiply(new BigDecimal(10)).divide(new BigDecimal(100));
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    MusicCD musicCD = (MusicCD) o;

    return amount != null ? amount.equals(musicCD.amount) : musicCD.amount == null;

  }

  @Override public int hashCode()
  {
    return amount != null ? amount.hashCode() : 0;
  }

  @Override public String toString()
  {
    return "MusicCD{" +
        "amount=" + amount +
        '}';
  }
}
