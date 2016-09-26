package com.gcipriano.katas.salestaxes.input;

import com.gcipriano.katas.salestaxes.model.product.*;

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

  public List<Product> convert()
  {
    List<Product> products = new ArrayList<>();

    Matcher matcher = Pattern.compile(PRODUCT_REGEX_PATTERN).matcher(textInput);

    while (hasNextProduct(matcher))
    {
      String description = matcher.group(1);
      String amount = matcher.group(2);

      products.add(new TaxableProduct(amount, description));
    }

    return products;
  }

  private boolean hasNextProduct(Matcher matcher)
  {
    return matcher.find();
  }
}
