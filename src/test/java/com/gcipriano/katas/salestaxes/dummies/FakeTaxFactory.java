package com.gcipriano.katas.salestaxes.dummies;

import com.gcipriano.katas.salestaxes.model.taxing.*;

public class FakeTaxFactory implements TaxFactory
{
  @Override public Tax taxFor(String description)
  {
    if (!description.equals("fixed products"))
    {
      return new PercentageTax(7);
    }

    throw new TaxNotFoundException(null);
  }
}
