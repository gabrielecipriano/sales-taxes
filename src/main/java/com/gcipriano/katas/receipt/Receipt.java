package com.gcipriano.katas.receipt;

public interface Receipt
{
  void addProduct(PresentableProduct product);

  void total(String amount);

  void taxTotal(String amount);

  String render();
}
