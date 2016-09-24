package com.gcipriano.katas.model.product;

import com.gcipriano.katas.model.product.Product;

import java.math.BigDecimal;

public class FixedAmountsProduct implements Product
{
  private final BigDecimal fixedTaxAmount;
  private final BigDecimal fixedAmount;

  public FixedAmountsProduct(BigDecimal fixedAmount, BigDecimal fixedTaxAmount)
  {
    this.fixedTaxAmount = fixedTaxAmount;
    this.fixedAmount = fixedAmount;
  }

  @Override public BigDecimal taxAmount()
  {
    return fixedTaxAmount;
  }

  @Override public BigDecimal amount()
  {
    return fixedAmount;
  }

  @Override public String description()
  {
    return "fixed product";
  }

  @Override public BigDecimal taxedPrice()
  {
    return fixedAmount.add(fixedTaxAmount);
  }
}
