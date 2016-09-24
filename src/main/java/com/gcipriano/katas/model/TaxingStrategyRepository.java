package com.gcipriano.katas.model;

public interface TaxingStrategyRepository
{
  TaxingStrategy strategyFor(String productName);
}
