package com.gcipriano.katas.model.product;

import java.math.BigDecimal;

public class AppliableStrategyProduct implements Product
{
  private final String name;
  private final BigDecimal amount;
  private final AppliableStrategy appliableStrategy;

  public AppliableStrategyProduct(String name, String amount, AppliableStrategy appliableStrategy)
  {
    this.name = name;
    this.amount = new BigDecimal(amount);
    this.appliableStrategy = appliableStrategy;
  }

  @Override public BigDecimal taxAmount()
  {
    return appliableStrategy.applyOn(amount);
  }

  @Override public BigDecimal amount()
  {
    return amount;
  }

  @Override public String description()
  {
    return name;
  }
}
