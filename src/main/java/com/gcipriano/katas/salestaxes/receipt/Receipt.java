package com.gcipriano.katas.salestaxes.receipt;

public interface Receipt
{
  void addProduct(PresentableProduct product);

  void total(String amount);

  void taxTotal(String amount);

  String render();
}
