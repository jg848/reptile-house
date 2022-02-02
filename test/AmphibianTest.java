
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import reptilehouse.Amphibian;
import reptilehouse.Animal;
import reptilehouse.AnimalSize;
import reptilehouse.Characteristics;
import reptilehouse.CharacteristicsImpl;
import reptilehouse.Indicators;
import reptilehouse.IndicatorsImpl;
import reptilehouse.NaturalFeatures;

/**
 * Test class for the Amphibian class which inherits the AnimalImpl class
 * implementing the Animal interface. Used to test the Amphibian animal species
 * type.
 * 
 * @author Jaswin Gumpella
 *
 */
public class AmphibianTest {

  SampleData data;
  Animal animal;

  /**
   * Method used to setup the required instances for test class.
   * 
   * @throws IllegalArgumentException in case of any exception.
   */
  @Before
  public void setUp() throws IllegalArgumentException {
    data = new SampleData();
  }

  /**
   * Test method for {@link reptilehouse.Amphibian#getSpecies()}.
   */
  @Test
  public final void testGetSpecies() {
    assertEquals("AMPHIBIAN", data.getGrayTreefrog().getSpecies());
  }

  /**
   * Test method for constructor of Amphibian class.
   */
  @Test
  public final void testAmphibian() {
    Characteristics characteristics = new CharacteristicsImpl(
        "Gray treefrogs have a white spot beneath each eye and "
            + "a dark stripe from the rear of the eyes to the front of the legs.",
        AnimalSize.SMALL);
    Indicators indicators = new IndicatorsImpl(true, false, false, false);
    this.animal = new Amphibian("Gray Treefrog", characteristics, 65, 80,
        NaturalFeatures.TREE_BRANCHES, indicators);
    assertEquals(Amphibian.class, this.animal.getClass());
  }

  /**
   * Test method for constructor of Amphibian class..
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAmphibianInvalidName() {
    Characteristics characteristics = new CharacteristicsImpl(
        "Gray treefrogs have a white spot beneath each eye and "
            + "a dark stripe from the rear of the eyes to the front of the legs.",
        AnimalSize.SMALL);
    Indicators indicators = new IndicatorsImpl(true, false, false, false);
    new Amphibian("", characteristics, 65, 80, NaturalFeatures.TREE_BRANCHES, indicators);
  }

  /**
   * Test method for constructor of Amphibian class.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAmphibianInvalidCharacteristics() {
    Characteristics characteristics = null;
    Indicators indicators = new IndicatorsImpl(true, false, false, false);
    new Amphibian("Gray Treefrog", characteristics, 65, 80, NaturalFeatures.TREE_BRANCHES,
        indicators);
  }

  /**
   * Test method for constructor of Amphibian class.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAmphibianInvalidTemperatures() {
    Characteristics characteristics = new CharacteristicsImpl(
        "Gray treefrogs have a white spot beneath each eye and "
            + "a dark stripe from the rear of the eyes to the front of the legs.",
        AnimalSize.SMALL);
    Indicators indicators = new IndicatorsImpl(true, false, false, false);
    new Amphibian("Gray Treefrog", characteristics, 65, 45, NaturalFeatures.TREE_BRANCHES,
        indicators);
  }

  /**
   * Test method for constructor of Amphibian class.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAmphibianInvalidNaturalFeature() {
    Characteristics characteristics = new CharacteristicsImpl(
        "Gray treefrogs have a white spot beneath each eye and "
            + "a dark stripe from the rear of the eyes to the front of the legs.",
        AnimalSize.SMALL);
    Indicators indicators = new IndicatorsImpl(true, false, false, false);
    new Amphibian("Gray Treefrog", characteristics, 65, 80, null, indicators);
  }

  /**
   * Test method for constructor of Amphibian class.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAmphibianInvalidIndicators() {
    Characteristics characteristics = new CharacteristicsImpl(
        "Gray treefrogs have a white spot beneath each eye and "
            + "a dark stripe from the rear of the eyes to the front of the legs.",
        AnimalSize.SMALL);
    Indicators indicators = null;
    new Amphibian("Gray Treefrog", characteristics, 65, 80, NaturalFeatures.TREE_BRANCHES,
        indicators);
  }

  /**
   * Test method for
   * {@link reptilehouse.AnimalImpl#checkAddAnimal(reptilehouse.Habitat)}.
   */
  @Test
  public final void testCheckAddAnimalTrue() {
    assertEquals(true, data.getGrayTreefrog().checkAddAnimal(data.getTexasHabitat()));
  }

  /**
   * Test method for
   * {@link reptilehouse.AnimalImpl#checkAddAnimal(reptilehouse.Habitat)}.
   */
  @Test
  public final void testCheckAddAnimalFalse() {
    assertEquals(false, data.getDesertTortoise().checkAddAnimal(data.getTexasHabitat()));
  }

  /**
   * Test method for {@link reptilehouse.AnimalImpl#isCoLive()}.
   */
  @Test
  public final void testIsCoLiveTrue() {
    assertEquals(true, data.getDesertTortoise().isCoLive());
  }

  /**
   * Test method for {@link reptilehouse.AnimalImpl#isCoLive()}.
   */
  @Test
  public final void testIsCoLiveFalse() {
    assertEquals(false, data.getGrayTreefrog().isCoLive());
  }

  /**
   * Test method for {@link reptilehouse.AnimalImpl#getAnimalSize()}.
   */
  @Test
  public final void testGetAnimalSizeSmall() {
    assertEquals(1, data.getGrayTreefrog().getAnimalSize());
  }

  /**
   * Test method for {@link reptilehouse.AnimalImpl#getAnimalSize()}.
   */
  @Test
  public final void testGetAnimalSizeMedium() {
    assertEquals(5, data.getDesertTortoise().getAnimalSize());
  }

  /**
   * Test method for {@link reptilehouse.AnimalImpl#getAnimalSize()}.
   */
  @Test
  public final void testGetAnimalSizeLarge() {
    assertEquals(10, data.getAmericanAlligator().getAnimalSize());
  }

  /**
   * Test method for {@link reptilehouse.AnimalImpl#getAnimalName()}.
   */
  @Test
  public final void testGetAnimalName() {
    assertEquals("Gray Treefrog", data.getGrayTreefrog().getAnimalName());
  }

  /**
   * Test method for {@link java.lang.Object#toString()}.
   */
  @Test
  public final void testToString() {
    String expected = "Species name: Gray Treefrog, "
        + "Description: Gray treefrogs have a white spot beneath each eye and "
        + "a dark stripe from the rear of the eyes to the front of the legs., "
        + "Size: SMALL, Poisonous: true, Endangered: false, "
        + "Extinct: false, Can live with other species: false";
    assertEquals(expected, data.getGrayTreefrog().toString());
  }

}