package com.gcipriano.katas.model;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_HALF_UP;

public class ImportedProduct implements Product
{
  private static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

  private Product product;

  public ImportedProduct(Product product)
  {
    this.product = product;
  }

  @Override public BigDecimal taxAmount()
  {
    return applyFivePercent().add(product.taxAmount());
  }

  @Override public BigDecimal amount()
  {
    return product.amount();
  }

  @Override public String description()
  {
    return "imported " + product.description();
  }

  private BigDecimal applyFivePercent()
  {
    return round((product.amount()).multiply(new BigDecimal(5)).divide(ONE_HUNDRED));
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

    ImportedProduct that = (ImportedProduct) o;

    return product != null ? product.equals(that.product) : that.product == null;

  }

  @Override public int hashCode()
  {
    return product != null ? product.hashCode() : 0;
  }

  @Override public String toString()
  {
    return "ImportedProduct{" +
        "product=" + product +
        '}';
  }
}
