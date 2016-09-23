package com.gcipriano.katas.model;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public class Book implements Product
{
  private BigDecimal amount;

  public Book(String amount)
  {
    this.amount = new BigDecimal(amount);
  }


  @Override public BigDecimal taxAmount()
  {
    return ZERO;
  }

  @Override public BigDecimal amount()
  {
    return amount;
  }

  @Override public String description()
  {
    return "book";
  }

  @Override public String toString()
  {
    return "Book{" +
        "amount=" + amount +
        '}';
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Book book = (Book) o;

    return amount != null ? amount.equals(book.amount) : book.amount == null;

  }

  @Override public int hashCode()
  {
    return amount != null ? amount.hashCode() : 0;
  }
}
