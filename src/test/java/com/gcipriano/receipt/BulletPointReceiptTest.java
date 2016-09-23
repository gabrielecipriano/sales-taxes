package com.gcipriano.receipt;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BulletPointReceiptTest
{
  @Test
  public void oneProductReceipt() throws Exception
  {
    BulletPointReceipt receipt = new BulletPointReceipt();

    receipt.addProduct("PRODUCT_NAME", "PRODUCT_PRICE");
    receipt.total("TOTAL");
    receipt.taxTotal("TAX_TOTAL");

    assertThat(receipt.render(), is("1 PRODUCT_NAME: PRODUCT_PRICE\n"
                                  + "Sales Taxes: TAX_TOTAL\n"
                                  + "Total: TOTAL"));
  }

  @Test
  public void twoProductReceipt() throws Exception
  {
    BulletPointReceipt receipt = new BulletPointReceipt();

    receipt.addProduct("PRODUCT_NAME", "PRODUCT_PRICE");
    receipt.addProduct("ANOTHER_PRODUCT_NAME", "ANOTHER_PRODUCT_PRICE");
    receipt.total("TOTAL");
    receipt.taxTotal("TAX_TOTAL");

    assertThat(receipt.render(), is("1 PRODUCT_NAME: PRODUCT_PRICE\n"
                                   +"1 ANOTHER_PRODUCT_NAME: ANOTHER_PRODUCT_PRICE\n"
                                   + "Sales Taxes: TAX_TOTAL\n"
                                   + "Total: TOTAL"));
  }
}