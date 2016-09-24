package com.gcipriano.katas.model.product;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;

public class NotImportedProduct implements Product
{
  private final String description;
  private final Tax tenPercent;
  private BigDecimal amount;

  public NotImportedProduct(String amount, String description, Tax tax)
  {
    this.amount = new BigDecimal(amount);
    this.description = description;
    tenPercent = tax;
  }

  @Override public BigDecimal taxAmount()
  {
    return applyTax();
  }

  @Override public BigDecimal amount()
  {
    return amount;
  }

  @Override public String description()
  {
    return description;
  }

  @Override public BigDecimal taxedPrice()
  {
    return amount().add(taxAmount());
  }

  private BigDecimal applyTax()
  {
    return round(tenPercent.applyOn(amount));
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

    NotImportedProduct that = (NotImportedProduct) o;

    if (description != null ? !description.equals(that.description) : that.description != null)
      return false;
    if (tenPercent != null ? !tenPercent.equals(that.tenPercent) : that.tenPercent != null)
      return false;
    return amount != null ? amount.equals(that.amount) : that.amount == null;

  }

  @Override public int hashCode()
  {
    int result = description != null ? description.hashCode() : 0;
    result = 31 * result + (tenPercent != null ? tenPercent.hashCode() : 0);
    result = 31 * result + (amount != null ? amount.hashCode() : 0);
    return result;
  }

  @Override public String toString()
  {
    return "NotImportedProduct{" +
        "description='" + description + '\'' +
        ", tenPercent=" + tenPercent +
        ", amount=" + amount +
        '}';
  }
}
