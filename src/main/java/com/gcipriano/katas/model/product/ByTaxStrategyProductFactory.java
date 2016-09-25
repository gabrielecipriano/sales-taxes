package com.gcipriano.katas.model.product;

import com.gcipriano.katas.model.taxing.*;

public class ByTaxStrategyProductFactory implements ProductFactory
{
  private final TaxRepository taxRepository;

  public ByTaxStrategyProductFactory(TaxRepository taxRepository)
  {
    this.taxRepository = taxRepository;
  }

  @Override
  public Product productFrom(String description, String amount)
  {
    return new TaxableProduct(amount, description, taxFor(description));
  }

  private Tax taxFor(String description)
  {
    return taxRepository.taxFor(description);
  }
}
