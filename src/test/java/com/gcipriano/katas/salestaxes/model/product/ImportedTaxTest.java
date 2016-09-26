package com.gcipriano.katas.salestaxes.model.product;

import com.gcipriano.katas.salestaxes.model.taxing.*;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ImportedTaxTest
{
  @Test
  public void applyAnAdditionalTax() throws Exception
  {
    Tax additionalTax = new PercentageTax(7);
    Tax normalTax = new PercentageTax(3);

    ImportedTax importedTax = new ImportedTax(normalTax, additionalTax);

    assertThat(importedTax.applyOn(new BigDecimal("100")), is(new BigDecimal("10")));
  }
}