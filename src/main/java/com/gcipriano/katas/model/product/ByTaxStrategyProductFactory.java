package com.gcipriano.katas.model.product;

import com.gcipriano.katas.model.taxing.*;

public class ByTaxStrategyProductFactory implements ProductFactory
{
  private final TaxingStrategyRepository taxingStrategyRepository;

  public ByTaxStrategyProductFactory(TaxingStrategyRepository taxingStrategyRepository)
  {
    this.taxingStrategyRepository = taxingStrategyRepository;
  }

  @Override
  public Product productFrom(String description, String amount)
  {
    if (isImported(description))
    {
      String name = description.replaceAll("imported ", "");

      return new ImportedProduct(productFrom(name, amount));
    }

    TaxingStrategy taxingStrategy = taxingStrategyRepository.strategyFor(description);

    return new NotImportedProduct(amount, description, taxingStrategy.tax());
  }

  private boolean isImported(String description)
  {
    return description.contains("imported");
  }
}
