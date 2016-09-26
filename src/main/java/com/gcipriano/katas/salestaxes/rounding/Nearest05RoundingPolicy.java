package com.gcipriano.katas.salestaxes.rounding;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Nearest05RoundingPolicy implements RoundingPolicy
{
  @Override public BigDecimal round(BigDecimal toRound)
  {
    return new BigDecimal(Math.ceil(toRound.doubleValue() * 20) / 20).setScale(2, RoundingMode.HALF_UP);
  }
}
