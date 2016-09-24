package com.gcipriano.katas.model.product;

import java.math.BigDecimal;

public interface Tax
{
  BigDecimal applyOn(BigDecimal amount);
}
