package com.gcipriano.katas.model;

public class MusicCD implements Product
{
  private String amount;

  public MusicCD(String amount)
  {
    this.amount = amount;
  }

  @Override public String toString()
  {
    return "MusicCD{" +
        "amount='" + amount + '\'' +
        '}';
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
}
