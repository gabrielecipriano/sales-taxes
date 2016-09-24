package com.gcipriano.katas.model.taxing;

public interface TaxingStrategyRepository
{
  TaxingStrategy strategyFor(String productName);
}
