package com.gcipriano.katas.model.product;

public interface ProductFactory
{
  Product productFrom(String description, String amount);
}
