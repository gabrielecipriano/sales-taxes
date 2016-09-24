package com.gcipriano.katas.input;

import com.gcipriano.katas.model.*;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TextInputTest
{
  @Test
  public void bookAndCD() throws Exception
  {
    TextInput textInput = new TextInput("1 book at 3.00"
                                            + " 1 music CD at 10.00");

    assertThat(textInput.convert(), is(asList(new TaxExemptedProduct("3.00", "book"),
                                              new TenPercentTaxedProduct("10.00", "music CD"))));
  }

  @Test
  public void priceWithDecimalPrecision() throws Exception
  {
    TextInput textInput = new TextInput("1 music CD at 10.30"
                                            + " 1 book at 4.35");

    assertThat(textInput.convert(), is(asList(new TenPercentTaxedProduct("10.30", "music CD"),
                                              new TaxExemptedProduct("4.35", "book"))));
  }

  @Test
  public void importedBook() throws Exception
  {
    TextInput textInput = new TextInput("1 music CD at 10.30"
                                            + " 1 imported book at 4.35");

    assertThat(textInput.convert(), is(asList(new TenPercentTaxedProduct("10.30", "music CD"),
                                              new ImportedProduct(new TaxExemptedProduct("4.35", "book")))));
  }
}