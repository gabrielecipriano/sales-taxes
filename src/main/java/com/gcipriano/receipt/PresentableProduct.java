package com.gcipriano.receipt;

public class PresentableProduct
{
  private String description;
  private String amount;

  public PresentableProduct(String description, String amount)
  {
    this.description = description;
    this.amount = amount;
  }

  public String description()
  {
    return description;
  }

  public String amount()
  {
    return amount;
  }
}

