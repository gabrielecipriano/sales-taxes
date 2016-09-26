package com.gcipriano.katas.salestaxes.model.product.catalog;

import com.gcipriano.katas.salestaxes.model.product.catalog.InMemoryExemptedProductCatalog;
import org.junit.Test;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InMemoryExemptedProductCatalogTest
{
  private final InMemoryExemptedProductCatalog inMemoryExemptedProductCatalog;

  public InMemoryExemptedProductCatalogTest()
  {
    inMemoryExemptedProductCatalog = new InMemoryExemptedProductCatalog(singletonList("EXEMPTED_PRODUCT"));
  }

  @Test
  public void bookIsExempted() throws Exception
  {
    assertTrue(inMemoryExemptedProductCatalog.isExempted("EXEMPTED_PRODUCT"));
  }

  @Test
  public void musicCD() throws Exception
  {
    assertFalse(inMemoryExemptedProductCatalog.isExempted("NOT_EXEMPTED_PRODUCT"));
  }
}