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
    assertThat(new MusicCD("14.99").taxAmount(), is(new BigDecimal("1.50")));
    assertThat(new MusicCD("33.30").taxAmount(), is(new BigDecimal("3.35")));
    assertThat(new MusicCD("21.20").taxAmount(), is(new BigDecimal("2.10")));
    assertThat(new MusicCD("10").amount(), is(new BigDecimal("10")));
  }
}