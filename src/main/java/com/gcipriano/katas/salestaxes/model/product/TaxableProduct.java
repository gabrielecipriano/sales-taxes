package com.gcipriano.katas.salestaxes.model.product;

import com.gcipriano.katas.salestaxes.model.taxing.Tax;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxableProduct implements Product
{
  private final String description;
  private final Tax tax;
  private BigDecimal amount;

  public TaxableProduct(String amount, String description, Tax tax)
  {
    this.amount = new BigDecimal(amount);
    this.description = description;
    this.tax = tax;
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
    return round(tax.applyOn(amount));
  }

  private BigDecimal round(BigDecimal toRound)
  {
    return new BigDecimal(Math.ceil(toRound.doubleValue() * 20) / 20).setScale(2, RoundingMode.HALF_UP);
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
    if (tax != null ? !tax.equals(that.tax) : that.tax != null)
      return false;
    return amount != null ? amount.equals(that.amount) : that.amount == null;

  }

  @Override public int hashCode()
  {
    int result = description != null ? description.hashCode() : 0;
    result = 31 * result + (tax != null ? tax.hashCode() : 0);
    result = 31 * result + (amount != null ? amount.hashCode() : 0);
    return result;
  }

  @Override public String toString()
  {
    return "TaxableProduct{" +
        "description='" + description + '\'' +
        ", tax=" + tax +
        ", amount=" + amount +
        '}';
  }
}
