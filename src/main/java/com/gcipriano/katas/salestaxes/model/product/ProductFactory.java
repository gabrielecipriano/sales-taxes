package com.gcipriano.katas.salestaxes.model.product;

public interface ProductFactory
{
  Product productFrom(String description, String amount);
}
