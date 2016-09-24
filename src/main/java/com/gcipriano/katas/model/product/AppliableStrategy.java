package com.gcipriano.katas.model.product;

import java.math.BigDecimal;

public interface AppliableStrategy
{
  BigDecimal applyOn(BigDecimal amount);
}
