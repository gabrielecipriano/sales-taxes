package com.gcipriano.katas.model.product;

import com.gcipriano.katas.model.taxing.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ByTaxStrategyProductFactoryTest
{
  private static final String UNKNOWN_PRODUCT = "UNKNOWN PRODUCT";

  private ByTaxStrategyProductFactory productFactory;

  @Before
  public void setUp() throws Exception
  {
    productFactory = new ByTaxStrategyProductFactory(new FakeTaxRepository());
  }

  @Test
  public void taxExemptProduct() throws Exception
  {
    Product product = productFactory.productFrom("PRODUCT_NAME", "3");

    assertThat(product, is(new TaxableProduct("3", "PRODUCT_NAME", new PercentageTax(7))));
  }

  @Test(expected = IllegalArgumentException.class)
  public void notRecognizedProduct() throws Exception
  {
    productFactory.productFrom(UNKNOWN_PRODUCT, "");
  }

  private class FakeTaxRepository implements TaxRepository
  {
    @Override public Tax taxFor(String description)
    {
      return new PercentageTax(7);
    }
  }
}