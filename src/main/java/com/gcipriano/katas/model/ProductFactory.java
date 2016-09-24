package com.gcipriano.katas.model;

public class ProductFactory
{

  private final InMemoryTaxingStrategyRepository taxingStrategyRepository;

  public ProductFactory()
  {
    taxingStrategyRepository = new InMemoryTaxingStrategyRepository();
  }

  public Product productFrom(String name, String amount)
  {
    TaxingStrategy taxingStrategy = taxingStrategyRepository.strategyFor(name);

    switch (taxingStrategy)
    {
      case TAX_EXEMPT:
        return new TaxExemptedProduct(amount, name);
      case TEN_PERCENT:
        return new TenPercentTaxedProduct(amount, name);
    }

    throw new IllegalArgumentException("not recognized Product");
  }
}
