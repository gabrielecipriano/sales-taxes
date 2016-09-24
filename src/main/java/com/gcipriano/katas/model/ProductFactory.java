package com.gcipriano.katas.model;

public class ProductFactory
{
  private final TaxingStrategyRepository taxingStrategyRepository;

  public ProductFactory(TaxingStrategyRepository taxingStrategyRepository)
  {
    this.taxingStrategyRepository = taxingStrategyRepository;
  }

  public Product productFrom(String name, String amount)
  {
    switch (taxingStrategyRepository.strategyFor(name))
    {
      case TAX_EXEMPT: return new TaxExemptedProduct(amount, name);

      case TEN_PERCENT: return new TenPercentTaxedProduct(amount, name);
    }

    throw new IllegalArgumentException("not recognized Product");
  }
}
