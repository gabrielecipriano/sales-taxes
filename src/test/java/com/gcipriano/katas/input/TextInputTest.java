package com.gcipriano.katas.input;

import com.gcipriano.katas.model.product.FixedAmountsProduct;
import com.gcipriano.katas.model.product.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static java.math.BigDecimal.*;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class TextInputTest
{
  private static final Product FIXED_AMOUNTS_PRODUCT = new FixedAmountsProduct(ONE, ZERO);
  private final ProductFactorySpy spy = new ProductFactorySpy();
  private final ProductFactory productFactory = new TraceableDummyProductFactory(spy);

  @Test
  public void bookAndCD() throws Exception
  {
    TextInput textInput = new TextInput("1 book at 3.00"
                                      + " 1 music CD at 10.00",
                                        productFactory);


    assertThat(textInput.convert(), is(asList(FIXED_AMOUNTS_PRODUCT, FIXED_AMOUNTS_PRODUCT)));
    assertTrue(spy.wasCalledWith("book", "3.00"));
    assertTrue(spy.wasCalledWith("music CD", "10.00"));
  }

  @Test
  public void priceWithDecimalPrecision() throws Exception
  {
    TextInput textInput = new TextInput("1 music CD at 10.30"
                                            + " 1 book at 4.35",
                                        productFactory);


    assertThat(textInput.convert(), is(asList(FIXED_AMOUNTS_PRODUCT, FIXED_AMOUNTS_PRODUCT)));
    assertTrue(spy.wasCalledWith("music CD", "10.30"));
    assertTrue(spy.wasCalledWith("book", "4.35"));
  }

  @Test
  public void importedBook() throws Exception
  {
    TextInput textInput = new TextInput("1 music CD at 1.00"
                                            + " 1 imported book at 2.00",
                                        productFactory);

    assertThat(textInput.convert(), is(asList(FIXED_AMOUNTS_PRODUCT, FIXED_AMOUNTS_PRODUCT)));

    assertTrue(spy.wasCalledWith("music CD", "1.00"));
    assertTrue(spy.wasCalledWith("imported book", "2.00"));
  }

  private class TraceableDummyProductFactory implements ProductFactory
  {
    private ProductFactorySpy spy;

    public TraceableDummyProductFactory(ProductFactorySpy spy)
    {
      this.spy = spy;
    }

    @Override
    public Product productFrom(String description, String amount)
    {
      spy.register(description, amount);
      return FIXED_AMOUNTS_PRODUCT;
    }
  }

  private class ProductFactorySpy
  {
    private final Map<String, String> calledWith = new HashMap<>();

    public void register(String description, String amount)
    {
      calledWith.put(description, amount);
    }

    public boolean wasCalledWith(String description, String amount)
    {
      return calledWith.get(description).equals(amount);
    }
  }
}