package com.gcipriano.katas.salestaxes.model.product;

import java.math.BigDecimal;

public class TaxableProduct implements Product
{
  private final String description;
  private BigDecimal amount;

  public TaxableProduct(String amount, String description)
  {
    this.amount = new BigDecimal(amount);
    this.description = description;
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

    TaxableProduct that = (TaxableProduct) o;

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
    return "TaxableProduct{" +
        "description='" + description + '\'' +
        ", amount=" + amount +
        '}';
  }
}
