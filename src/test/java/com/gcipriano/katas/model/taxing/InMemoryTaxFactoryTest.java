package com.gcipriano.katas.model.taxing;

import com.gcipriano.katas.model.product.catalog.ProductCatalog;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class InMemoryTaxFactoryTest
{
  private static final String EXEMPTED_PRODUCT = "EXEMPTED_PRODUCT";

  private InMemoryTaxFactory inMemoryTaxRepository;

  @Before
  public void setUp() throws Exception
  {
    inMemoryTaxRepository = new InMemoryTaxFactory(new FakeProductCatalog());
  }

  @Test
  public void exempted() throws Exception
  {
    assertThat(inMemoryTaxRepository.taxFor("EXEMPTED_PRODUCT"), is(new PercentageTax(0)));
  }

  @Test
  public void notExempted() throws Exception
  {
    assertThat(inMemoryTaxRepository.taxFor("NORMAL_PRODUCT"), is(new PercentageTax(10)));
  }

  @Test
  public void importedHeadachePills() throws Exception
  {
    assertThat(inMemoryTaxRepository.taxFor("imported EXEMPTED_PRODUCT"), is(new ImportedTax(new PercentageTax(0), new PercentageTax(5))));
  }

  @Test
  public void importedPerfume() throws Exception
  {
    assertThat(inMemoryTaxRepository.taxFor("imported NORMAL_PRODUCT"), is(new ImportedTax(new PercentageTax(10), new PercentageTax(5))));
  }

  private class FakeProductCatalog implements ProductCatalog
  {
    @Override
    public boolean isExempted(String description)
    {
      return description.contains(EXEMPTED_PRODUCT);
    }
  }
}