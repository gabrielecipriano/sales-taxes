package com.gcipriano.katas.model;

public class ChocolateBar implements Product
{
  private String amount;

  public ChocolateBar(String amount)
  {
    this.amount = amount;
  }

  @Override public String toString()
  {
    return "ChocolateBar{" +
        "amount='" + amount + '\'' +
        '}';
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
}
