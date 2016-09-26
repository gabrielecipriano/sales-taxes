package com.gcipriano.katas.salestaxes.model.product;

import com.gcipriano.katas.salestaxes.model.product.*;
import com.gcipriano.katas.salestaxes.model.taxing.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TaxableProductFactoryTest
{
  private static final String UNKNOWN_DESCRIPTION = "UNKNOWN PRODUCT";
  private static final String PRODUCT_NAME = "PRODUCT_NAME";
  private static final String PRODUCT_AMOUNT = "3";
  private static final PercentageTax TAX = new PercentageTax(7);

  private TaxableProductFactory productFactory;

  @Before
  public void setUp() throws Exception
  {
    productFactory = new TaxableProductFactory(new FakeTaxFactory());
  }

  @Test
  public void taxExemptProduct() throws Exception
  {
    Product product = productFactory.productFrom(PRODUCT_NAME, "3");

    assertThat(product, is(new TaxableProduct(PRODUCT_AMOUNT, PRODUCT_NAME, TAX)));
  }

  @Test(expected = ProductDescriptionNotRecognizedException.class)
  public void notRecognizedProduct() throws Exception
  {
    productFactory.productFrom(UNKNOWN_DESCRIPTION, "");
  }

  private class FakeTaxFactory implements TaxFactory
  {
    @Override public Tax taxFor(String description)
    {
      if (!description.equals(UNKNOWN_DESCRIPTION))
      {
        return TAX;
      }

      throw new TaxNotFoundException(null);
    }
  }
}