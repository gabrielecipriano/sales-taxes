package com.gcipriano.katas.model.taxing;

public interface TaxRepository
{
  Tax taxFor(String description);
}
