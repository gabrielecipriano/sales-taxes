package com.gcipriano.katas.receipt;

public interface Receipt
{
  void addProduct(String description, String amount);

  void total(String amount);

  void taxTotal(String amount);

  String render();
}
