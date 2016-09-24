package com.gcipriano.katas.model;

import com.gcipriano.katas.model.taxing.InMemoryTaxingStrategyRepository;
import org.junit.Before;
import org.junit.Test;

import static com.gcipriano.katas.model.taxing.TaxingStrategy.*;
import static com.gcipriano.katas.model.taxing.TaxingStrategy.TAX_EXEMPT;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class InMemoryTaxingStrategyRepositoryTest
{
  private InMemoryTaxingStrategyRepository strategyRepository;

  @Before
  public void setUp() throws Exception
  {
    strategyRepository = new InMemoryTaxingStrategyRepository();
  }

  @Test
  public void book() throws Exception
  {
    assertThat(strategyRepository.strategyFor("book"), is(TAX_EXEMPT));
  }

  @Test
  public void musicCD() throws Exception
  {
    assertThat(strategyRepository.strategyFor("music CD"), is(TEN_PERCENT));
  }

  @Test
  public void chocolateBar() throws Exception
  {
    assertThat(strategyRepository.strategyFor("chocolate bar"), is(TAX_EXEMPT));
  }

  @Test
  public void boxOfChocolate() throws Exception
  {
    assertThat(strategyRepository.strategyFor("box of chocolates"), is(TAX_EXEMPT));
  }

  @Test
  public void headachePills() throws Exception
  {
    assertThat(strategyRepository.strategyFor("packet of headache pills"), is(TAX_EXEMPT));
  }

  @Test
  public void perfume() throws Exception
  {
    assertThat(strategyRepository.strategyFor("bottle of perfume"), is(TEN_PERCENT));
  }
}