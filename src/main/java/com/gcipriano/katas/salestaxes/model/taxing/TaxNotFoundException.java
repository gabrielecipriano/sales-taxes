package com.gcipriano.katas.salestaxes.model.taxing;

public class TaxNotFoundException extends RuntimeException
{
  public TaxNotFoundException(String productName)
  {
    super("Couldn't find tax for :" + productName);
  }
}
