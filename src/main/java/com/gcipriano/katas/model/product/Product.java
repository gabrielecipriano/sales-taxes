package com.gcipriano.katas.model.product;

import java.math.BigDecimal;

public interface Product
{
  BigDecimal taxAmount();

  BigDecimal amount();

  String description();

  BigDecimal taxedPrice();
}
