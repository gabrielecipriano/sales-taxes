import com.gcipriano.katas.ShoppingBasket;
import com.gcipriano.katas.input.TextInput;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AcceptanceTest
{
  @Test
  public void firstScenario() throws Exception
  {
    ShoppingBasket shoppingBasket = new ShoppingBasket(new TextInput("1 book at 12.49 "
                                                       + "1 music CD at 14.99 "
                                                       + "1 chocolate bar at 0.85 "));

    assertThat(shoppingBasket.receipt(), is("1 book: 12.49\n"
                                     + "1 music CD: 16.49\n"
                                     + "1 chocolate bar: 0.85\n"
                                     + "Sales Taxes: 1.50\n"
                                     + "Total: 29.83"));
  }
}
