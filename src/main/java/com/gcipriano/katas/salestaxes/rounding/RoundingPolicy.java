package com.gcipriano.katas.salestaxes.rounding;

import java.math.BigDecimal;

public interface RoundingPolicy
{
  BigDecimal round(BigDecimal toRound);
}
