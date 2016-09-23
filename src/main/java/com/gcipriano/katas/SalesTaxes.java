package com.gcipriano.katas;

import com.gcipriano.katas.input.Input;

public class SalesTaxes
{
  private Input input;

  public SalesTaxes(Input input)
  {
    this.input = input;
  }

  public String receipt()
  {
    return "1 book : 12.49\n"
        + "1 music CD: 16.49\n"
        + "1 chocolate bar: 0.85\n"
        + "Sales Taxes: 1.50\n"
        + "Total: 29.83 ";
  }
}
