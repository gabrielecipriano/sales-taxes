package com.gcipriano.katas.salestaxes.model;

import com.gcipriano.katas.salestaxes.model.ShoppingBasket;
import com.gcipriano.katas.salestaxes.model.product.FixedAmountsProduct;
import com.gcipriano.katas.salestaxes.model.taxing.*;
import com.gcipriano.katas.salestaxes.receipt.PresentableProduct;
import com.gcipriano.katas.salestaxes.receipt.Receipt;
import org.junit.Before;
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

  private ShoppingBasket basket;

  @Before
  public void setUp() throws Exception
  {
    basket = new ShoppingBasket(new FakeReceipt(), new FakeTaxFactory(), new TwoDecimalRoundingPolicy());
  }

  @Test
  public void oneProductReceipt() throws Exception
  {
    assertThat(basket.receiptFor(asList(A_PRODUCT, ANOTHER_PRODUCT)).render(), is("107.00 fixed product\n"
                                                                       + "13.27 fixed product\n"
                                                                       + "T 120.27\n"
                                                                       + "taxT 7.87"));
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

  private class FakeTaxFactory implements TaxFactory
  {
    @Override public Tax taxFor(String description)
    {
      if (!description.equals("fixed products"))
      {
        return new PercentageTax(7);
      }

      throw new TaxNotFoundException(null);
    }
  }

  private class TwoDecimalRoundingPolicy implements RoundingPolicy
  {
    @Override public BigDecimal round(BigDecimal toRound)
    {
      return toRound.setScale(2, BigDecimal.ROUND_UP);
    }
  }
}