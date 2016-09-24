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

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    AppliableStrategyProduct that = (AppliableStrategyProduct) o;

    if (name != null ? !name.equals(that.name) : that.name != null)
      return false;
    if (amount != null ? !amount.equals(that.amount) : that.amount != null)
      return false;
    return appliableStrategy != null ?
        appliableStrategy.equals(that.appliableStrategy) :
        that.appliableStrategy == null;

  }

  @Override public int hashCode()
  {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (amount != null ? amount.hashCode() : 0);
    result = 31 * result + (appliableStrategy != null ? appliableStrategy.hashCode() : 0);
    return result;
  }

  @Override public String toString()
  {
    return "AppliableStrategyProduct{" +
        "name='" + name + '\'' +
        ", amount=" + amount +
        ", appliableStrategy=" + appliableStrategy +
        '}';
  }
}
