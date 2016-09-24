package com.gcipriano.katas.model.taxing;

import com.gcipriano.katas.model.product.Tax;

public enum TaxingStrategy
{
  TEN_PERCENT(new PercentageTax(10)),
  TAX_EXEMPT(new TaxExempt());

  private Tax tax;

  TaxingStrategy(Tax tax)
  {
    this.tax = tax;
  }

  public Tax tax()
  {
    return tax;
  }
}
