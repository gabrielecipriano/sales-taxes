package com.gcipriano.katas.model.product;

import com.gcipriano.katas.model.taxing.TenPercent;

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
    return round(new TenPercent().applyOn(amount));
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

    TenPercentTaxedProduct that = (TenPercentTaxedProduct) o;

    if (description != null ? !description.equals(that.description) : that.description != null)
      return false;
    return amount != null ? amount.equals(that.amount) : that.amount == null;

  }

  @Override public int hashCode()
  {
    int result = description != null ? description.hashCode() : 0;
    result = 31 * result + (amount != null ? amount.hashCode() : 0);
    return result;
  }

  @Override public String toString()
  {
    return "TenPercentTaxedProduct{" +
        "description='" + description + '\'' +
        ", amount=" + amount +
        '}';
  }
}
