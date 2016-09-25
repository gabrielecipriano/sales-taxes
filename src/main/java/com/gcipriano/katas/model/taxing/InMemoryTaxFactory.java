package com.gcipriano.katas.model.taxing;

import com.gcipriano.katas.model.product.catalog.ProductCatalog;

public class InMemoryTaxFactory implements TaxFactory
{
  private ProductCatalog productCatalog;

  public InMemoryTaxFactory(ProductCatalog productCatalog)
  {
    this.productCatalog = productCatalog;
  }

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
    return new ImportedTax(standardTaxFor(description.replaceAll("imported ", "")), new PercentageTax(5));
  }

  private Tax standardTaxFor(String description)
  {
    if (productCatalog.isExempted(description))
    {
      return new PercentageTax(0);
    }

    return new PercentageTax(10);
  }
}
