import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import reptilehouse.Animal;
import reptilehouse.AnimalSize;
import reptilehouse.Characteristics;
import reptilehouse.CharacteristicsImpl;
import reptilehouse.Indicators;
import reptilehouse.IndicatorsImpl;
import reptilehouse.NaturalFeatures;
import reptilehouse.Reptile;

/**
 * Test class for the Reptile class which inherits the AnimalImpl class
 * implementing the Animal interface. Used to test the Reptile animal species
 * type.
 * 
 * @author Jaswin Gumpella
 *
 */
public class ReptileTest {

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
   * Test method for {@link reptilehouse.Reptile#getSpecies()}.
   */
  @Test
  public final void testGetSpecies() {
    assertEquals("REPTILE", data.getDesertTortoise().getSpecies());
  }

  /**
   * Test method for constructor of Reptile class.
   */
  @Test
  public final void testReptile() {
    Characteristics characteristics = new CharacteristicsImpl(
        "Desert tortoises dig underground burrows "
            + "in order to hide from the sun in the deep desert.",
        AnimalSize.MEDIUM);
    Indicators indicators = new IndicatorsImpl(false, false, false, true);
    this.animal = new Reptile("Desert Tortoise", characteristics, 75, 100, NaturalFeatures.DESERT,
        indicators);
    assertEquals(Reptile.class, this.animal.getClass());
  }

  /**
   * Test method for constructor of Reptile class.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testReptileInvalidName() {
    Characteristics characteristics = new CharacteristicsImpl(
        "Desert tortoises dig underground burrows "
            + "in order to hide from the sun in the deep desert.",
        AnimalSize.MEDIUM);
    Indicators indicators = new IndicatorsImpl(false, false, false, true);
    new Reptile("", characteristics, 75, 100, NaturalFeatures.DESERT, indicators);
  }

  /**
   * Test method for constructor of Reptile class.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testReptileInvalidCharacteristics() {
    Characteristics characteristics = null;
    Indicators indicators = new IndicatorsImpl(false, false, false, true);
    new Reptile("Desert Tortoise", characteristics, 75, 100, NaturalFeatures.DESERT, indicators);
  }

  /**
   * Test method for constructor of Reptile class.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testReptileInvalidTemperatures() {
    Characteristics characteristics = new CharacteristicsImpl(
        "Desert tortoises dig underground burrows "
            + "in order to hide from the sun in the deep desert.",
        AnimalSize.MEDIUM);
    Indicators indicators = new IndicatorsImpl(false, false, false, true);
    new Reptile("Desert Tortoise", characteristics, 75, 10, NaturalFeatures.DESERT, indicators);
  }

  /**
   * Test method for constructor of Reptile class.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testReptileInvalidNaturalFeature() {
    Characteristics characteristics = new CharacteristicsImpl(
        "Desert tortoises dig underground burrows "
            + "in order to hide from the sun in the deep desert.",
        AnimalSize.MEDIUM);
    Indicators indicators = new IndicatorsImpl(false, false, false, true);
    new Reptile("Desert Tortoise", characteristics, 75, 100, null, indicators);
  }

  /**
   * Test method for constructor of Reptile class.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testReptileInvalidIndicators() {
    Characteristics characteristics = new CharacteristicsImpl(
        "Desert tortoises dig underground burrows "
            + "in order to hide from the sun in the deep desert.",
        AnimalSize.MEDIUM);
    Indicators indicators = null;
    new Reptile("Desert Tortoise", characteristics, 75, 100, NaturalFeatures.DESERT, indicators);
  }

  /**
   * Test method for
   * {@link reptilehouse.AnimalImpl#checkAddAnimal(reptilehouse.Habitat)}.
   */
  @Test
  public final void testCheckAddAnimalTrue() {
    assertEquals(true, data.getDesertTortoise().checkAddAnimal(data.getNevadaHabitat()));
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
    assertEquals("Desert Tortoise", data.getDesertTortoise().getAnimalName());
  }

  /**
   * Test method for {@link java.lang.Object#toString()}.
   */
  @Test
  public final void testToString() {
    String expected = "Species name: Desert Tortoise, "
        + "Description: Desert tortoises dig underground burrows "
        + "in order to hide from the sun in the deep desert., "
        + "Size: MEDIUM, Poisonous: false, Endangered: false, "
        + "Extinct: false, Can live with other species: true";
    assertEquals(expected, data.getDesertTortoise().toString());
  }

}
