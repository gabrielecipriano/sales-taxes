package com.gcipriano.katas.model.taxing;

import com.gcipriano.katas.model.product.AppliableStrategy;

import java.math.BigDecimal;

public class TaxExemptStrategy implements AppliableStrategy
{
  @Override public BigDecimal applyOn(BigDecimal amount)
  {
    return amount;
  }
}
