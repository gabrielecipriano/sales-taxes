package com.gcipriano.katas;

import com.gcipriano.katas.input.Input;
import com.gcipriano.katas.model.product.Product;
import com.gcipriano.katas.receipt.PresentableProduct;
import com.gcipriano.katas.receipt.Receipt;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public class ShoppingBasket
{
  private Input input;
  private final Receipt receipt;

  public ShoppingBasket(Input input, Receipt receipt)
  {
    this.input = input;
    this.receipt = receipt;
  }

  public String receipt()
  {
    BigDecimal taxTotalAmount = ZERO;
    BigDecimal totalAmount = ZERO;

    for (Product product : input.convert())
    {
      BigDecimal finalPrice = product.taxedPrice();
      taxTotalAmount = taxTotalAmount.add(product.taxAmount());
      totalAmount = totalAmount.add(finalPrice);

      receipt.addProduct(new PresentableProduct(product.description(), finalPrice.toString()));
    }

    receipt.taxTotal(taxTotalAmount.toString());
    receipt.total(totalAmount.toString());

    return receipt.render();
  }
}
