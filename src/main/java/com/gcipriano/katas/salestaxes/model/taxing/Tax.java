package com.gcipriano.katas.salestaxes.model.taxing;

import java.math.BigDecimal;

public interface Tax
{
  BigDecimal applyOn(BigDecimal amount);
}
