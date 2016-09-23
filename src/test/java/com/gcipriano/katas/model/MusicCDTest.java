package com.gcipriano.katas.model;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MusicCDTest
{
  @Test
  public void tenPercentTax() throws Exception
  {
    assertThat(new MusicCD("10").taxAmount(), is(new BigDecimal("1")));
    assertThat(new MusicCD("10").amount(), is(new BigDecimal("10")));
  }
}