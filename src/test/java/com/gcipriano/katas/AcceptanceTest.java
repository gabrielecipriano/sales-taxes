package com.gcipriano.katas;

import com.gcipriano.katas.input.TextInput;
import com.gcipriano.katas.model.product.ByTaxStrategyProductFactory;
import com.gcipriano.katas.model.taxing.InMemoryTaxRepository;
import com.gcipriano.katas.receipt.BulletPointReceipt;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AcceptanceTest
{
  @Test
  public void firstScenario() throws Exception
  {
    ShoppingBasket shoppingBasket = new ShoppingBasket(new TextInput("1 book at 12.49 "
                                                                   + "1 music CD at 14.99 "
                                                                   + "1 chocolate bar at 0.85 ",
                                                                     new ByTaxStrategyProductFactory(new InMemoryTaxRepository())),
                                                       new BulletPointReceipt());

    assertThat(shoppingBasket.receipt(), is("1 book: 12.49\n"
                                          + "1 music CD: 16.49\n"
                                          + "1 chocolate bar: 0.85\n"
                                          + "Sales Taxes: 1.50\n"
                                          + "Total: 29.83"));
  }

  @Test
  public void secondScenario() throws Exception
  {
    ShoppingBasket shoppingBasket = new ShoppingBasket(new TextInput("1 imported box of chocolates at 10.00 "
                                                                   + "1 imported bottle of perfume at 47.50",
                                                                     new ByTaxStrategyProductFactory(new InMemoryTaxRepository())),
                                                       new BulletPointReceipt());

    assertThat(shoppingBasket.receipt(), is("1 imported box of chocolates: 10.50\n"
                                          + "1 imported bottle of perfume: 54.65\n"
                                          + "Sales Taxes: 7.65\n"
                                          + "Total: 65.15"));

  }

  @Test
  public void thirdScenario() throws Exception
  {
    ShoppingBasket shoppingBasket = new ShoppingBasket(new TextInput("1 imported bottle of perfume at 27.99 "
                                                                   + "1 bottle of perfume at 18.99 "
                                                                   + "1 packet of headache pills at 9.75 "
                                                                   + "1 imported box of chocolates at 11.25",
                                                                     new ByTaxStrategyProductFactory(new InMemoryTaxRepository())),
                                                       new BulletPointReceipt());

    assertThat(shoppingBasket.receipt(), is("1 imported bottle of perfume: 32.19\n"
                                          + "1 bottle of perfume: 20.89\n"
                                          + "1 packet of headache pills: 9.75\n"
                                          + "1 imported box of chocolates: 11.85\n"
                                          + "Sales Taxes: 6.70\n"
                                          + "Total: 74.68"));
  }
}
