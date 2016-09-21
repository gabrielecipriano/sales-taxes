import com.gcipriano.katas.SalesTaxes;
import com.gcipriano.katas.input.Input;
import com.gcipriano.katas.input.TextInput;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AcceptanceTest
{
  @Test
  public void firstScenario() throws Exception
  {
    SalesTaxes salesTaxes = new SalesTaxes(new TextInput("1 book at 12.49 "
                                                       + "1 music CD at 14.99 "
                                                       + "1 chocolate bar at 0.85 "));

    assertThat(salesTaxes.receipt(), is("1 book : 12.49\n"
                                     + "1 music CD: 16.49\n"
                                     + "1 chocolate bar: 0.85\n"
                                     + "Sales Taxes: 1.50\n"
                                     + "Total: 29.83 "));
  }
}
