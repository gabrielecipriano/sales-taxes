package com.gcipriano.katas.salestaxes.model.taxing;

import java.math.BigDecimal;

public interface RoundingPolicy
{
  BigDecimal round(BigDecimal toRound);
}
