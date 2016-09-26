package com.gcipriano.katas.salestaxes.model;

import com.gcipriano.katas.salestaxes.model.product.Product;
import com.gcipriano.katas.salestaxes.model.taxing.*;
import com.gcipriano.katas.salestaxes.receipt.PresentableProduct;
import com.gcipriano.katas.salestaxes.receipt.Receipt;

import java.math.BigDecimal;
import java.util.List;

import static java.math.BigDecimal.ZERO;

public class ShoppingBasket
{
  private final Receipt receipt;
  private final TaxFactory taxFactory;
  private final RoundingPolicy roundingPolicy;

  public ShoppingBasket(Receipt receipt, TaxFactory taxFactory, RoundingPolicy roundingPolicy)
  {
    this.receipt = receipt;
    this.taxFactory = taxFactory;
    this.roundingPolicy = roundingPolicy;
  }

  public Receipt receiptFor(List<Product> products)
  {
    BigDecimal taxTotalAmount = ZERO;
    BigDecimal totalAmount = ZERO;

    for (Product product : products)
    {
      BigDecimal taxAmount = round(taxOn(product));

      BigDecimal finalPrice = taxAmount.add(product.amount());
      taxTotalAmount = taxTotalAmount.add(taxAmount);
      totalAmount = totalAmount.add(finalPrice);

      receipt.addProduct(new PresentableProduct(product.description(), finalPrice.toString()));
    }

    receipt.taxTotal(taxTotalAmount.toString());
    receipt.total(totalAmount.toString());

    return receipt;
  }

  private BigDecimal taxOn(Product product)
  {
    return taxFor(product).applyOn(product.amount());
  }

  private BigDecimal round(BigDecimal toRound)
  {
    return roundingPolicy.round(toRound);
  }

  private Tax taxFor(Product product)
  {
    return taxFactory.taxFor(product.description());
  }
}
