package com.gcipriano.katas.input;

import com.gcipriano.katas.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class TextInput implements Input
{
  private static final String PRODUCT_REGEX_PATTERN = "\\d* (\\D*) at (\\d*\\.\\d{2})";

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
      String description = matcher.group(1);
      String amount = matcher.group(2);

      products.add(new ProductFactory(new InMemoryTaxingStrategyRepository()).productFrom(description, amount));
    }

    return products;
  }g
}
