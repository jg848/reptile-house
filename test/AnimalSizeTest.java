
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import reptilehouse.AnimalSize;

/**
 * Class used to test the enumerations of Animal Size.
 * 
 * @author Jaswin Gumpella
 *
 */
public class AnimalSizeTest {

  /**
   * Method used to test the SMALL enum value of AnimalSize.
   */
  @Test
  public final void testAnimalSizeSmall() {
    assertEquals("SMALL", AnimalSize.SMALL.name());
  }

  /**
   * Method used to test the MEDIUM enum value of AnimalSize.
   */
  @Test
  public final void testAnimalSizeMedium() {
    assertEquals("MEDIUM", AnimalSize.MEDIUM.name());
  }

  /**
   * Method used to test the LARGE enum value of AnimalSize.
   */
  @Test
  public final void testAnimalSizeLarge() {
    assertEquals("LARGE", AnimalSize.LARGE.name());
  }

}
