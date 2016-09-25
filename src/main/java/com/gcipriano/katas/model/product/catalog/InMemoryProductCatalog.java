package com.gcipriano.katas.model.product.catalog;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class InMemoryProductCatalog implements ProductCatalog
{
  private List<String> exemptedProducts = new ArrayList<>();

  public InMemoryProductCatalog()
  {
    exemptedProducts = asList("book", "chocolate bar", "box of chocolates", "packet of headache pills");
  }

  @Override public boolean isExempted(String description)
  {
    return exemptedProducts.contains(description);
  }
}
