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

    assertThat(textInput.process(), is(asList(new Book("3.00"),
                                              new MusicCD("10.00"))));
  }

  @Test
  public void twoMusicCDAndChocolateBar() throws Exception
  {
    TextInput textInput = new TextInput("2 music CD at 10.00"
                                            + " 1 chocolate bar at 4.00");

    assertThat(textInput.process(), is(asList(new MusicCD("10.00"),
                                              new MusicCD("10.00"),
                                              new ChocolateBar("4.00"))));
  }

  @Test
  public void priceWithDecimalPrecision() throws Exception
  {
    TextInput textInput = new TextInput("1 music CD at 10.30"
                                            + " 1 book at 4.35");

    assertThat(textInput.process(), is(asList(new MusicCD("10.30"),
                                              new Book("4.35"))));
  }

  @Test
  public void importedBook() throws Exception
  {
    TextInput textInput = new TextInput("1 music CD at 10.30"
                                            + " 1 imported book at 4.35");

    assertThat(textInput.process(), is(asList(new MusicCD("10.30"),
                                              new ImportedProduct(new Book("4.35")))));
  }
}