package com.gcipriano.katas.model.taxing;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class InMemoryTaxRepositoryTest
{
  private InMemoryTaxRepository inMemoryTaxRepository;

  @Before
  public void setUp() throws Exception
  {
    inMemoryTaxRepository = new InMemoryTaxRepository();
  }

  @Test
  public void book() throws Exception
  {
    assertThat(inMemoryTaxRepository.taxFor("book"), is(new PercentageTax(0)));
  }

  @Test
  public void musicCD() throws Exception
  {
    assertThat(inMemoryTaxRepository.taxFor("music CD"), is(new PercentageTax(10)));
  }

  @Test
  public void chocolateBar() throws Exception
  {
    assertThat(inMemoryTaxRepository.taxFor("chocolate bar"), is(new PercentageTax(0)));
  }

  @Test
  public void boxOfChocolate() throws Exception
  {
    assertThat(inMemoryTaxRepository.taxFor("box of chocolates"), is(new PercentageTax(0)));
  }

  @Test
  public void headachePills() throws Exception
  {
    assertThat(inMemoryTaxRepository.taxFor("packet of headache pills"), is(new PercentageTax(0)));
  }

  @Test
  public void perfume() throws Exception
  {
    assertThat(inMemoryTaxRepository.taxFor("bottle of perfume"), is(new PercentageTax(10)));
  }

  @Test
  public void importedBook() throws Exception
  {
    assertThat(inMemoryTaxRepository.taxFor("imported book"), is(new ImportedTax(new PercentageTax(0), new PercentageTax(5))));
  }

  @Test
  public void importedMusicCD() throws Exception
  {
    assertThat(inMemoryTaxRepository.taxFor("imported music CD"), is(new ImportedTax(new PercentageTax(10), new PercentageTax(5))));
  }

  @Test
  public void importedChocolateBar() throws Exception
  {
    assertThat(inMemoryTaxRepository.taxFor("imported chocolate bar"), is(new ImportedTax(new PercentageTax(0), new PercentageTax(5))));
  }

  @Test
  public void importedBoxOfChocolate() throws Exception
  {
    assertThat(inMemoryTaxRepository.taxFor("imported box of chocolates"), is(new ImportedTax(new PercentageTax(0), new PercentageTax(5))));
  }

  @Test
  public void importedHeadachePills() throws Exception
  {
    assertThat(inMemoryTaxRepository.taxFor("imported packet of headache pills"), is(new ImportedTax(new PercentageTax(0), new PercentageTax(5))));
  }

  @Test
  public void importedPerfume() throws Exception
  {
    assertThat(inMemoryTaxRepository.taxFor("imported bottle of perfume"), is(new ImportedTax(new PercentageTax(10), new PercentageTax(5))));
  }
}