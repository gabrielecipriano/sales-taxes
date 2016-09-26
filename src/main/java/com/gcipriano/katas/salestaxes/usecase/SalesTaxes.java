package com.gcipriano.katas.salestaxes.usecase;

import com.gcipriano.katas.salestaxes.input.Input;

public class SalesTaxes
{
  private ShoppingBasket shoppingBasket;

  public SalesTaxes(ShoppingBasket shoppingBasket)
  {
    this.shoppingBasket = shoppingBasket;
  }

  public String receipt(Input input)
  {
    return shoppingBasket.receiptFor(input.convert());
  }
}
