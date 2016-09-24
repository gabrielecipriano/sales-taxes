package com.gcipriano.katas.model;

public class ProductFactory
{
  public Product productFrom(String name, String amount)
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

    throw new IllegalArgumentException("not recognized Product");
  }
}
