package com.gcipriano.katas.model.taxing;

import com.gcipriano.katas.model.product.catalog.ExemptedProductCatalog;

public class InMemoryTaxFactory implements TaxFactory
{
  private ExemptedProductCatalog exemptedProductCatalog;

  public InMemoryTaxFactory(ExemptedProductCatalog exemptedProductCatalog)
  {
    this.exemptedProductCatalog = exemptedProductCatalog;
  }

  @Override public Tax taxFor(String description)
  {
    if (isImported(description))
    {
      return importedTaxFor(description);
    }

    return standardTaxFor(description);
  }

  private ImportedTax importedTaxFor(String description)
  {
    return new ImportedTax(standardTaxFor(realProductName(description)), importedTax());
  }

  private String realProductName(String description)
  {
    return description.replaceAll("imported ", "");
  }

  private PercentageTax importedTax()
  {
    return new PercentageTax(5);
  }

  private Tax standardTaxFor(String description)
  {
    if (exemptedProductCatalog.isExempted(description))
    {
      return new PercentageTax(0);
    }

    return new PercentageTax(10);
  }

  private boolean isImported(String description)
  {
    return description.contains("imported");
  }
}
