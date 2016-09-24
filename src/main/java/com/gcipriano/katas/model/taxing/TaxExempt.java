package com.gcipriano.katas.model.taxing;

import com.gcipriano.katas.model.product.Tax;

import java.math.BigDecimal;

public class TaxExempt implements Tax
{
  @Override public BigDecimal applyOn(BigDecimal amount)
  {
    return amount;
  }
}
