package com.gcipriano.katas.model.product.catalog;

import org.junit.Test;

import static org.junit.Assert.*;

public class InMemoryProductCatalogTest
{
  private final InMemoryProductCatalog inMemoryProductCatalog;

  public InMemoryProductCatalogTest()
  {
    inMemoryProductCatalog = new InMemoryProductCatalog();
  }

  @Test
  public void bookIsExempted() throws Exception
  {
    assertTrue(inMemoryProductCatalog.isExempted("book"));
  }
  @Test
  public void musicCD() throws Exception
  {
    assertFalse(inMemoryProductCatalog.isExempted("music CD"));
  }

  @Test
  public void chocolateBar() throws Exception
  {
    assertTrue(inMemoryProductCatalog.isExempted("chocolate bar"));
  }

  @Test
  public void boxOfChocolate() throws Exception
  {
    assertTrue(inMemoryProductCatalog.isExempted("box of chocolates"));
  }

  @Test
  public void headachePills() throws Exception
  {
    assertTrue(inMemoryProductCatalog.isExempted("packet of headache pills"));
  }

  @Test
  public void perfume() throws Exception
  {
    assertFalse(inMemoryProductCatalog.isExempted("bottle of perfume"));
  }
}