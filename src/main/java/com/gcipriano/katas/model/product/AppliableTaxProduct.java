package com.gcipriano.katas.model.product;

import java.math.BigDecimal;

public class AppliableTaxProduct implements Product
{
  private final String name;
  private final BigDecimal amount;
  private final Tax tax;

  public AppliableTaxProduct(String name, String amount, Tax tax)
  {
    this.name = name;
    this.amount = new BigDecimal(amount);
    this.tax = tax;
  }

  @Override public BigDecimal taxAmount()
  {
    return tax.applyOn(amount);
  }

  @Override public BigDecimal amount()
  {
    return amount;
  }

  @Override public String description()
  {
    return name;
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    AppliableTaxProduct that = (AppliableTaxProduct) o;

    if (name != null ? !name.equals(that.name) : that.name != null)
      return false;
    if (amount != null ? !amount.equals(that.amount) : that.amount != null)
      return false;
    return tax != null ?
        tax.equals(that.tax) :
        that.tax == null;

  }

  @Override public int hashCode()
  {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (amount != null ? amount.hashCode() : 0);
    result = 31 * result + (tax != null ? tax.hashCode() : 0);
    return result;
  }

  @Override public String toString()
  {
    return "AppliableTaxProduct{" +
        "name='" + name + '\'' +
        ", amount=" + amount +
        ", tax=" + tax +
        '}';
  }
}
