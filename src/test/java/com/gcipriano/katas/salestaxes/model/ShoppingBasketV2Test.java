package com.gcipriano.katas.salestaxes.model;

import com.gcipriano.katas.salestaxes.dummies.FakeTaxFactory;
import com.gcipriano.katas.salestaxes.dummies.TwoDecimalRoundingPolicy;
import com.gcipriano.katas.salestaxes.model.product.Product;
import com.gcipriano.katas.salestaxes.receipt.PresentableProduct;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ShoppingBasketV2Test
{

  private ShoppingBasketV2 shoppingBasket;

  @Before
  public void setUp() throws Exception
  {
    shoppingBasket = new ShoppingBasketV2(new TwoDecimalRoundingPolicy(),
                                          new FakeTaxFactory());
  }

  @Test
  public void oneProductBasket() throws Exception
  {
    shoppingBasket.addProduct(new Product("7.34", "description"));

    assertThat(shoppingBasket.products(), is(singletonList(new PresentableProduct("description", "7.86"))));
    assertThat(shoppingBasket.total(), is(new BigDecimal("7.86")));
    assertThat(shoppingBasket.taxTotal(), is(new BigDecimal("0.52")));
  }

  @Test
  public void twoProductBasket() throws Exception
  {
    shoppingBasket.addProduct(new Product("6.72", "description"));
    shoppingBasket.addProduct(new Product("5.12", "description"));

    assertThat(shoppingBasket.products(), is(asList(new PresentableProduct("description", "7.20"), new PresentableProduct("description", "5.48"))));
    assertThat(shoppingBasket.total(), is(new BigDecimal("12.68")));
    assertThat(shoppingBasket.taxTotal(), is(new BigDecimal("0.84")));
  }
}