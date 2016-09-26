package com.gcipriano.katas.salestaxes.model.taxing;

import java.math.BigDecimal;

public class ImportedTax implements Tax
{
  private final Tax normalTax;
  private final Tax additionalTax;

  public ImportedTax(Tax normalTax, Tax additionalTax)
  {
    this.normalTax = normalTax;
    this.additionalTax = additionalTax;
  }

  @Override public BigDecimal applyOn(BigDecimal amount)
  {
    return additionalTax.applyOn(amount).add(normalTax.applyOn(amount));
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    ImportedTax that = (ImportedTax) o;

    if (normalTax != null ? !normalTax.equals(that.normalTax) : that.normalTax != null)
      return false;
    return additionalTax != null ? additionalTax.equals(that.additionalTax) : that.additionalTax == null;

  }

  @Override public int hashCode()
  {
    int result = normalTax != null ? normalTax.hashCode() : 0;
    result = 31 * result + (additionalTax != null ? additionalTax.hashCode() : 0);
    return result;
  }

  @Override public String toString()
  {
    return "ImportedTax{" +
        "normalTax=" + normalTax +
        ", additionalTax=" + additionalTax +
        '}';
  }
}
