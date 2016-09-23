package com.gcipriano.katas.model;

public class Book implements Product
{
  private String amount;

  public Book(String amount)
  {
    this.amount = amount;
  }

  @Override public String toString()
  {
    return "Book{" +
        "amount='" + amount + '\'' +
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
