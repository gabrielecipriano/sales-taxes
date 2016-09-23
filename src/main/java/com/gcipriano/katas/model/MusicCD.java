package com.gcipriano.katas.model;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;

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

  @Override public String description()
  {
    return "music CD";
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
