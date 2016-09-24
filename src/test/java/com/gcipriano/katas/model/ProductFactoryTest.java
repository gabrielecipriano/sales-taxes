package com.gcipriano.katas.model;

import com.gcipriano.katas.model.product.*;
import com.gcipriano.katas.model.taxing.TaxingStrategy;
import com.gcipriano.katas.model.taxing.TaxingStrategyRepository;
import org.junit.Before;
import org.junit.Test;

import static com.gcipriano.katas.model.taxing.TaxingStrategy.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProductFactoryTest
{
  private static final String TAX_EXEMPT_PRODUCT = "TAX_EXEMPT_PRODUCT";
  private static final String TEN_PERCENT_TAXED_PRODUCT = "TEN_PERCENT_TAXED_PRODUCT";
  private static final String UNKNOWN_PRODUCT = "UNKNOWN PRODUCT";

  private ProductFactory productFactory;

  @Before
  public void setUp() throws Exception
  {
    productFactory = new ProductFactory(new FakeTaxingStrategyRepository());
  }

  @Test
  public void taxExemptProduct() throws Exception
  {
    Product product = productFactory.productFrom(TAX_EXEMPT_PRODUCT, "3");

    assertThat(product, is(new TaxExemptedProduct("3", TAX_EXEMPT_PRODUCT)));
  }

  @Test
  public void tenPercentTaxedProduct() throws Exception
  {
    Product product = productFactory.productFrom(TEN_PERCENT_TAXED_PRODUCT, "1");

    assertThat(product, is(new TenPercentTaxedProduct("1", TEN_PERCENT_TAXED_PRODUCT)));
  }

  @Test
  public void importedTenPercentTaxedProduct() throws Exception
  {
    Product product = productFactory.productFrom("imported " + TEN_PERCENT_TAXED_PRODUCT, "1");

    assertThat(product, is(new ImportedProduct(new TenPercentTaxedProduct("1", TEN_PERCENT_TAXED_PRODUCT))));
  }

  @Test
  public void importedTaxExemptProduct() throws Exception
  {
    Product product = productFactory.productFrom("imported " + TAX_EXEMPT_PRODUCT, "1");

    assertThat(product, is(new ImportedProduct(new TaxExemptedProduct("1", TAX_EXEMPT_PRODUCT))));
  }

  @Test(expected = IllegalArgumentException.class)
  public void notRecognizedProduct() throws Exception
  {
    productFactory.productFrom(UNKNOWN_PRODUCT, "");
  }

  private class FakeTaxingStrategyRepository implements TaxingStrategyRepository
  {
    @Override public TaxingStrategy strategyFor(String productName)
    {
      if (productName.equals(TAX_EXEMPT_PRODUCT))
      {
        return TAX_EXEMPT;
      }
      else if(productName.equals(TEN_PERCENT_TAXED_PRODUCT))
      {
        return TEN_PERCENT;
      }

      throw new IllegalArgumentException();
    }
  }
}