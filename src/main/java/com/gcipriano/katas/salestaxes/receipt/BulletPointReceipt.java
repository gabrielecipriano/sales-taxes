package com.gcipriano.katas.salestaxes.receipt;

import java.util.ArrayList;
import java.util.List;

public class BulletPointReceipt implements Receipt
{
  private String taxTotal;
  private String total;
  private List<PresentableProduct> products = new ArrayList<>();

  @Override public void addProduct(PresentableProduct product)
  {
    products.add(product);
  }

  @Override public void total(String amount)
  {
    total = amount;
  }

  @Override public void taxTotal(String amount)
  {
    taxTotal = amount;
  }

  @Override public String render()
  {
    return products()
        + salesTaxes()
        + total();
  }

  private String products()
  {
    String productsLines = "";

    for (PresentableProduct product : products)
    {
      productsLines += render(product);
    }

    return productsLines;
  }

  private String total()
  {
    return "Total: " + total;
  }

  private String salesTaxes()
  {
    return "Sales Taxes: " + taxTotal + "\n";
  }

  private String render(PresentableProduct product)
  {
    return "1 " + product.description() + ": " + product.amount() + "\n";
  }
}
