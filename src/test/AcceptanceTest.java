import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AcceptanceTest
{
  @Test
  public void firstScenario() throws Exception
  {
    assertThat(true, is(true));
  }
}
