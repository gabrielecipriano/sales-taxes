package com.gcipriano.katas.model.product;

import com.gcipriano.katas.model.taxing.*;

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
