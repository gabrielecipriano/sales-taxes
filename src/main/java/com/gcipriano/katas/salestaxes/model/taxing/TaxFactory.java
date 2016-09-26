package com.gcipriano.katas.salestaxes.model.taxing;

public interface TaxFactory
{
  Tax taxFor(String description);
}
