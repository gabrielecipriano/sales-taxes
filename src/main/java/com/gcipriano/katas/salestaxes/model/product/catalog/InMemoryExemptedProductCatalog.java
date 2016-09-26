package com.gcipriano.katas.salestaxes.model.product.catalog;

import java.util.ArrayList;
import java.util.List;

public class InMemoryExemptedProductCatalog implements ExemptedProductCatalog
{
  private List<String> exemptedProducts = new ArrayList<>();

  public InMemoryExemptedProductCatalog(List<String> exemptedProducts)
  {
    this.exemptedProducts = exemptedProducts;
  }

  @Override public boolean isExempted(String description)
  {
    return exemptedProducts.contains(description);
  }
}
