package com.gcipriano.katas.model;

import java.math.BigDecimal;

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

  private BigDecimal applyFivePercent()
  {
    return (product.amount()).multiply(new BigDecimal(5)).divide(ONE_HUNDRED);
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
