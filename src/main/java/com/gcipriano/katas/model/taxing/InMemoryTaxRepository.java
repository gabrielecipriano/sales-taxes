package com.gcipriano.katas.model.taxing;

public class InMemoryTaxRepository implements TaxRepository
{
  @Override public Tax taxFor(String description)
  {
    if (description.contains("imported"))
    {
      return importedTaxFor(description);
    }

    return standardTaxFor(description);
  }

  private ImportedTax importedTaxFor(String description)
  {
    return new ImportedTax(standardTaxFor(description.replaceAll("imported", "")), new PercentageTax(5));
  }

  private Tax standardTaxFor(String description)
  {
    if (isFood(description) || isMedicine(description))
    {
      return new PercentageTax(0);
    }

    return new PercentageTax(10);
  }

  private boolean isMedicine(String productName)
  {
    return productName.contains("pills");
  }

  private boolean isFood(String productName)
  {
    return productName.contains("book") || productName.contains("chocolate");
  }
}
