package com.gcipriano.katas.model;

import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BookTest
{
  @Test
  public void noTaxes() throws Exception
  {
    assertThat(new Book("10").taxAmount(), is(ZERO));
    assertThat(new Book("10").amount(), is(new BigDecimal(10)));
  }
}