package com.gcipriano.katas.input;

import com.gcipriano.katas.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class TextInput implements Input
{
  private static final String PRODUCT_REGEX_PATTERN = "(\\d*) (\\D*) at (\\d*\\.\\d{2})";

  private String textInput;

  public TextInput(String textInput)
  {
    this.textInput = textInput;
  }

  public List<Product> process()
  {
    List<Product> products = new ArrayList<>();

    Matcher matcher = Pattern.compile(PRODUCT_REGEX_PATTERN).matcher(textInput);

    while (matcher.find())
    {
      int quantity = parseInt(matcher.group(1));
      String name = matcher.group(2);
      String description = matcher.group(3);

      for (int i = 0; i < quantity; i++)
      {
        products.add(productFrom(name, description));
      }
    }

    return products;
  }

  private Product productFrom(String name, String amount)
  {
    switch (name)
    {
      case "book": return new Book(amount);
      case "music CD": return new MusicCD(amount);
      case "chocolate bar": return new ChocolateBar(amount);
    }

    throw new IllegalArgumentException();
  }
}
