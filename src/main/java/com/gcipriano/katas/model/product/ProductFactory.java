package com.gcipriano.katas.model.product;

import com.gcipriano.katas.model.taxing.TaxingStrategyRepository;

public class ProductFactory
{
  private final TaxingStrategyRepository taxingStrategyRepository;

  public ProductFactory(TaxingStrategyRepository taxingStrategyRepository)
  {
    this.taxingStrategyRepository = taxingStrategyRepository;
  }

  public Product productFrom(String description, String amount)
  {
    if (isImported(description))
    {
      String name = description.replaceAll("imported ", "");

      return new ImportedProduct(productFrom(name, amount));
    }

    switch (taxingStrategyRepository.strategyFor(description))
    {
      case TAX_EXEMPT: return new TaxExemptedProduct(amount, description);

      case TEN_PERCENT: return new TenPercentTaxedProduct(amount, description);
    }

    throw new IllegalArgumentException("not recognized Product");
  }

  private boolean isImported(String description)
  {
    return description.contains("imported");
  }
}
