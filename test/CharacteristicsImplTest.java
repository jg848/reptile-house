import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import reptilehouse.AnimalSize;
import reptilehouse.Characteristics;
import reptilehouse.CharacteristicsImpl;

/**
 * Test class for CharacteristicsImpl class which implements the Characteristics
 * interface. Used to test the defining characteristics of an animal like
 * description and animal size.
 * 
 * @author Jaswin Gumpella
 *
 */
public class CharacteristicsImplTest {

  Characteristics characteristics;

  /**
   * Method used to setup the required instances for the test class.
   * 
   * @throws IllegalArgumentException in case of any exception.
   */
  @Before
  public void setUp() throws IllegalArgumentException {
    characteristics = new CharacteristicsImpl(
        "Gray treefrogs have a white spot beneath each eye and"
            + " a dark stripe from the rear of the eyes to the front of the legs.",
        AnimalSize.SMALL);
  }

  /**
   * Test method for
   * {@link reptilehouse.CharacteristicsImpl #CharacteristicsImpl(String, AnimalSize)}.
   */
  @Test
  public final void testCharacteristicsImpl() {
    characteristics = new CharacteristicsImpl(
        "Gray treefrogs have a white spot beneath each eye and"
            + "a dark stripe from the rear of the eyes to the front of the legs.",
        AnimalSize.SMALL);
    assertEquals(CharacteristicsImpl.class, characteristics.getClass());
  }

  /**
   * Test method for
   * {@link reptilehouse.CharacteristicsImpl#CharacteristicsImpl(String, AnimalSize)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCharacteristicsImplInvalidDescription() {
    new CharacteristicsImpl("", AnimalSize.SMALL);
  }

  /**
   * Test method for
   * {@link reptilehouse.CharacteristicsImpl#CharacteristicsImpl(String, AnimalSize)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCharacteristicsImplInvalidAnimalSize() {
    new CharacteristicsImpl("Gray treefrogs have a white spot beneath each eye and"
        + " a dark stripe from the rear of the eyes to the front of the legs.", null);
  }

  /**
   * Test method for {@link reptilehouse.CharacteristicsImpl#getDescription()}.
   */
  @Test
  public final void testGetDescription() {
    String expected = "Gray treefrogs have a white spot beneath each eye and"
        + " a dark stripe from the rear of the eyes to the front of the legs.";
    assertEquals(expected, characteristics.getDescription());
  }

  /**
   * Test method for {@link reptilehouse.CharacteristicsImpl#getAnimalSize()}.
   */
  @Test
  public final void testGetAnimalSizeSmall() {
    characteristics = new CharacteristicsImpl(
        "Gray treefrogs have a white spot beneath each eye and"
            + " a dark stripe from the rear of the eyes to the front of the legs.",
        AnimalSize.SMALL);
    assertEquals(AnimalSize.SMALL, characteristics.getAnimalSize());
  }

  /**
   * Test method for {@link reptilehouse.CharacteristicsImpl#getAnimalSize()}.
   */
  @Test
  public final void testGetAnimalSizeMedium() {
    characteristics = new CharacteristicsImpl("Desert tortoises dig underground burrows "
        + "in order to hide from the sun in the deep desert.", AnimalSize.MEDIUM);
    assertEquals(AnimalSize.MEDIUM, characteristics.getAnimalSize());
  }

  /**
   * Test method for {@link reptilehouse.CharacteristicsImpl#getAnimalSize()}.
   */
  @Test
  public final void testGetAnimalSizeLarge() {
    characteristics = new CharacteristicsImpl(
        "American alligator is capable of biting through a turtle's shell"
            + " or a moderately sized mammal bone.",
        AnimalSize.LARGE);
    assertEquals(AnimalSize.LARGE, characteristics.getAnimalSize());
  }

}
