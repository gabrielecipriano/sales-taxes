package com.gcipriano.katas.model;

import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ChocolateBarTest
{
  @Test
  public void noTaxes() throws Exception
  {
    assertThat(new ChocolateBar("10").taxAmount(), is(ZERO));
    assertThat(new ChocolateBar("10").amount(), is(new BigDecimal(10)));
  }
}