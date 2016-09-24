package com.gcipriano.katas.model;

import static com.gcipriano.katas.model.TaxingStrategy.*;

public class InMemoryTaxingStrategyRepository implements TaxingStrategyRepository
{
  @Override
  public TaxingStrategy strategyFor(String productName)
  {
    if (isFood(productName) || isMedicine(productName))
    {
      return TAX_EXEMPT;
    }

    return TEN_PERCENT;
  }

  private boolean isMedicine(String productName)
  {
    return productName.contains("pills");
  }

  private boolean isFood(String productName)
  {
    return productName.equals("book") || productName.contains("chocolate");
  }
}
