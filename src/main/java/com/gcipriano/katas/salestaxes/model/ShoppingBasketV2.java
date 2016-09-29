package com.gcipriano.katas.salestaxes.model;

import com.gcipriano.katas.salestaxes.model.product.Product;
import com.gcipriano.katas.salestaxes.model.taxing.Tax;
import com.gcipriano.katas.salestaxes.model.taxing.TaxFactory;
import com.gcipriano.katas.salestaxes.receipt.PresentableProduct;
import com.gcipriano.katas.salestaxes.rounding.RoundingPolicy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigDecimal.ZERO;
import static java.util.Arrays.asList;

public class ShoppingBasketV2
{
  private final RoundingPolicy roundingPolicy;
  private final TaxFactory taxFactory;

  private List<PresentableProduct> products = new ArrayList<>();

  private BigDecimal taxTotal = ZERO;
  private BigDecimal total = ZERO;

  public ShoppingBasketV2(RoundingPolicy roundingPolicy, TaxFactory taxFactory)
  {
    this.roundingPolicy = roundingPolicy;
    this.taxFactory = taxFactory;
  }

  public void addProduct(Product product)
  {
    Tax tax = taxFactory.taxFor("description");

    BigDecimal duty = roundingPolicy.round(tax.applyOn(product.netPrice()));
    BigDecimal dutyPrice = product.netPrice().add(duty);

    products.add(new PresentableProduct(product.description(), dutyPrice.toString()));
    total = total.add(dutyPrice);
    taxTotal = taxTotal.add(duty);
  }

  public List<PresentableProduct> products()
  {
    return new ArrayList<>(products);
  }

  public BigDecimal total()
  {
    return total;
  }

  public BigDecimal taxTotal()
  {
    return taxTotal;
  }
}
