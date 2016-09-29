package com.gcipriano.katas.salestaxes.receipt;

public class PresentableProduct
{
  private String description;
  private String amount;

  public PresentableProduct(String description, String amount)
  {
    this.description = description;
    this.amount = amount;
  }

  public String description()
  {
    return description;
  }

  public String amount()
  {
    return amount;
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    PresentableProduct that = (PresentableProduct) o;

    if (description != null ? !description.equals(that.description) : that.description != null)
      return false;
    return amount != null ? amount.equals(that.amount) : that.amount == null;

  }

  @Override public int hashCode()
  {
    int result = description != null ? description.hashCode() : 0;
    result = 31 * result + (amount != null ? amount.hashCode() : 0);
    return result;
  }

  @Override public String toString()
  {
    return "PresentableProduct{" +
        "description='" + description + '\'' +
        ", amount='" + amount + '\'' +
        '}';
  }
}

