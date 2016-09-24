package com.gcipriano.katas;

import com.gcipriano.katas.input.Input;
import com.gcipriano.katas.model.FixedAmountsProduct;
import com.gcipriano.katas.model.product.Product;
import com.gcipriano.katas.receipt.BulletPointReceipt;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ShoppingBasketTest
{
  @Test
  public void oneProductReceipt() throws Exception
  {
    ShoppingBasket basket = new ShoppingBasket(new FixedProductsInput(new FixedAmountsProduct(new BigDecimal("100"),
                                                                                              new BigDecimal("2.45"))),
                                               new BulletPointReceipt());

    assertThat(basket.receipt(), is("1 fixed product: 102.45\n"
                                        + "Sales Taxes: 2.45\n"
                                        + "Total: 102.45"));
  }

  private class FixedProductsInput implements Input
  {
    private FixedAmountsProduct fixedAmountsProduct;

    public FixedProductsInput(FixedAmountsProduct fixedAmountsProduct)
    {
      this.fixedAmountsProduct = fixedAmountsProduct;
    }

    @Override public List<Product> convert()
    {
      return singletonList(fixedAmountsProduct);
    }
  }
}