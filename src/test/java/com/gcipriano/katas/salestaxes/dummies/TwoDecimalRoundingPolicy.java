package com.gcipriano.katas.salestaxes.dummies;

import com.gcipriano.katas.salestaxes.rounding.RoundingPolicy;

import java.math.BigDecimal;

public class TwoDecimalRoundingPolicy implements RoundingPolicy
{
  @Override public BigDecimal round(BigDecimal toRound)
  {
    return toRound.setScale(2, BigDecimal.ROUND_UP);
  }
}
