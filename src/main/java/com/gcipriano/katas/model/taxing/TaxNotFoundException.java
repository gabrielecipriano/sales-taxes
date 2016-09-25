package com.gcipriano.katas.model.taxing;

public class TaxNotFoundException extends RuntimeException
{
  public TaxNotFoundException(String productName)
  {
    super("Couldn't find tax for :" + productName);
  }
}
