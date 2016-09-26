package com.gcipriano.katas.salestaxes.usecase;

import com.gcipriano.katas.salestaxes.input.Input;
import com.gcipriano.katas.salestaxes.model.product.FixedAmountsProduct;
import com.gcipriano.katas.salestaxes.model.product.Product;
import com.gcipriano.katas.salestaxes.receipt.PresentableProduct;
import com.gcipriano.katas.salestaxes.receipt.Receipt;
import com.gcipriano.katas.salestaxes.usecase.ShoppingBasket;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ShoppingBasketTest
{
  private static final FixedAmountsProduct ANOTHER_PRODUCT = new FixedAmountsProduct(new BigDecimal("12.40"), new BigDecimal("2"));
  private static final FixedAmountsProduct A_PRODUCT = new FixedAmountsProduct(new BigDecimal("100"), new BigDecimal("2.45"));

  @Test
  public void oneProductReceipt() throws Exception
  {
    ShoppingBasket basket = new ShoppingBasket(new FixedProductsInput(A_PRODUCT, ANOTHER_PRODUCT),
                                               new FakeReceipt());

    assertThat(basket.receipt(), is("102.45 fixed product\n"
                                  + "14.40 fixed product\n"
                                  + "T 116.85\n"
                                  + "taxT 4.45"));
  }

  private class FixedProductsInput implements Input
  {
    private List<Product> fixedAmountsProducts;

    FixedProductsInput(FixedAmountsProduct... fixedAmountsProducts)
    {
      this.fixedAmountsProducts = asList(fixedAmountsProducts);
    }

    @Override public List<Product> convert()
    {
      return fixedAmountsProducts;
    }
  }

  private class FakeReceipt implements Receipt
  {
    private List<PresentableProduct> products = new ArrayList<>();
    private String total;
    private String taxTotal;

    @Override public void addProduct(PresentableProduct product)
    {
      products.add(product);
    }

    @Override public void total(String amount)
    {
      this.total = amount;
    }

    @Override public void taxTotal(String amount)
    {
      this.taxTotal = amount;
    }

    @Override public String render()
    {
      String receipt = "";

      for (PresentableProduct product : products)
      {
        receipt += product.amount() + " " + product.description() + "\n";
      }

      return receipt + "T " + total + "\ntaxT " + taxTotal;
    }
  }
}