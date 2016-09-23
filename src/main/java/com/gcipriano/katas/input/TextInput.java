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

      products.add(productFrom(description, amount));
    }

    return products;
  }

  private Product productFrom(String description, String amount)
  {
    if (description.contains("imported"))
    {
      String name = description.replaceAll("imported ", "");

      return new ImportedProduct(productOf(name, amount));
    }

    return productOf(description, amount);
  }

  private Product productOf(String name, String amount)
  {
    switch (name)
    {
      case "book":
        return new TaxExemptedGood(amount, "book");
      case "music CD":
        return new TenPercentTaxedProduct(amount, "music CD");
      case "chocolate bar":
        return new TaxExemptedGood(amount, "chocolate bar");
      case "box of chocolates":
        return new TaxExemptedGood(amount, "box of chocolates");
      case "bottle of perfume":
        return new TenPercentTaxedProduct(amount, "bottle of perfume");
      case "packet of headache pills":
        return new TaxExemptedGood(amount, "packet of headache pills");
    }

    return new TaxExemptedGood(name, "book");
  }
}
