package com.gcipriano.katas.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProductFactoryTest
{

  private ProductFactory productFactory;

  @Before
  public void setUp() throws Exception
  {
    productFactory = new ProductFactory();
  }

  @Test
  public void book() throws Exception
  {
    assertThat(productFactory.productFrom("book", "3"), is(new TaxExemptedGood("3", "book")));
  }

  @Test
  public void musicCD() throws Exception
  {
    assertThat(productFactory.productFrom("music CD", "1"), is(new TenPercentTaxedProduct("1", "music CD")));
  }


  @Test
  public void chocolateBar() throws Exception
  {
    assertThat(productFactory.productFrom("chocolate bar", "2"), is(new TaxExemptedGood("2", "chocolate bar")));
  }

  @Test
  public void boxOfChocolate() throws Exception
  {
    assertThat(productFactory.productFrom("box of chocolates", "123"), is(new TaxExemptedGood("123", "box of chocolates")));
  }

  @Test
  public void headachePills() throws Exception
  {
    assertThat(productFactory.productFrom("packet of headache pills", "232"), is(new TaxExemptedGood("232", "packet of headache pills")));
  }
}