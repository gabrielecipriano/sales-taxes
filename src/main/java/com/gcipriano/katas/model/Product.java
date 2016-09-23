package com.gcipriano.katas.model;

import java.math.BigDecimal;

public interface Product
{
  BigDecimal taxAmount();

  BigDecimal amount();

  String description();
}
