package com.gcipriano.katas.salestaxes.usecase;

import com.gcipriano.katas.salestaxes.input.Input;
import com.gcipriano.katas.salestaxes.receipt.Receipt;

public class SalesTaxes
{
  private ShoppingBasket shoppingBasket;

  public SalesTaxes(ShoppingBasket shoppingBasket)
  {
    this.shoppingBasket = shoppingBasket;
  }

  public String receipt(Input input)
  {
    return receiptFor(input).render();
  }

  private Receipt receiptFor(Input input)
  {
    return shoppingBasket.receiptFor(input.convert());
  }
}
