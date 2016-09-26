package com.gcipriano.katas.salestaxes.model.product;

import com.gcipriano.katas.salestaxes.model.taxing.Tax;
import com.gcipriano.katas.salestaxes.model.taxing.TaxFactory;

public class TaxableProductFactory implements ProductFactory
{
  private final TaxFactory taxFactory;

  public TaxableProductFactory(TaxFactory taxFactory)
  {
    this.taxFactory = taxFactory;
  }

  @Override
  public Product productFrom(String description, String amount)
  {
    try
    {
      return new TaxableProduct(amount, description, taxFor(description));
    }
    catch (RuntimeException e)
    {
      throw new ProductDescriptionNotRecognizedException();
    }
  }

  private Tax taxFor(String description)
  {
    return taxFactory.taxFor(description);
  }
}
