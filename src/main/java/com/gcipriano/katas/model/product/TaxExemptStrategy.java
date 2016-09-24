package com.gcipriano.katas.model.product;

import java.math.BigDecimal;

public class TaxExemptStrategy implements AppliableStrategy
{
  @Override public BigDecimal applyOn(BigDecimal amount)
  {
    return amount;
  }
}
