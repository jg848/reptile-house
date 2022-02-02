import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import reptilehouse.AnimalSize;
import reptilehouse.Characteristics;
import reptilehouse.CharacteristicsImpl;
import reptilehouse.Indicators;
import reptilehouse.IndicatorsImpl;
import reptilehouse.NaturalFeatures;
import reptilehouse.ReptileHouse;
import reptilehouse.ReptileHouseImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for ReptileHouseImpl class which implements the ReptileHouse
 * interface. Used to test the functions of a Reptile House.
 * 
 * @author Jaswin Gumpella
 *
 */
public class ReptileHouseImplTest {

  ReptileHouse reptileHouse;

  /**
   * Method used to setup the required instances for the test class.
   * 
   * @throws IllegalArgumentException in case of any exception.
   */
  @Before
  public void setUp() throws IllegalArgumentException {
    reptileHouse = new ReptileHouseImpl(100, 3);
  }

  /**
   * Test method for
   * {@link reptilehouse.ReptileHouseImpl#ReptileHouseImpl(int, int)}.
   */
  @Test
  public final void testReptileHouseImpl() {
    reptileHouse = new ReptileHouseImpl(100, 3);
    assertEquals(ReptileHouseImpl.class, reptileHouse.getClass());
  }

  /**
   * Test method for
   * {@link reptilehouse.ReptileHouseImpl#ReptileHouseImpl(int, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testReptileHouseImplInvalidArea() {
    new ReptileHouseImpl(-100, 3);
  }

  /**
   * Test method for
   * {@link reptilehouse.ReptileHouseImpl#ReptileHouseImpl(int, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testReptileHouseImplInvalidMaximumNumberOfHabitats() {
    new ReptileHouseImpl(100, -3);
  }

  /**
   * Test method for
   * {@link reptilehouse.ReptileHouseImpl#createHabitat(String, int, List, String, int, int)}.
   */
  @Test
  public final void testCreateHabitat() {
    List<NaturalFeatures> naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.TREE_BRANCHES);
    naturalFeatures.add(NaturalFeatures.FLOWING_WATER);
    naturalFeatures.add(NaturalFeatures.GRASS);
    assertEquals(true,
        reptileHouse.createHabitat("Texas Reptile Zoo", 30, naturalFeatures, "Texas", 36, 96));
  }

  /**
   * Test method for
   * {@link reptilehouse.ReptileHouseImpl#createHabitat(String, int, List, String, int, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateHabitatInvalidHabitatSize() {
    List<NaturalFeatures> naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.TREE_BRANCHES);
    naturalFeatures.add(NaturalFeatures.FLOWING_WATER);
    naturalFeatures.add(NaturalFeatures.GRASS);
    reptileHouse.createHabitat("Texas Reptile Zoo", 130, naturalFeatures, "Texas", 36, 96);
  }

  /**
   * Test method for
   * {@link reptilehouse.ReptileHouseImpl#createHabitat(String, int, List, String, int, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testCreateHabitatMaximumHabitatsReached() {
    List<NaturalFeatures> naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.TREE_BRANCHES);
    naturalFeatures.add(NaturalFeatures.FLOWING_WATER);
    naturalFeatures.add(NaturalFeatures.GRASS);
    reptileHouse.createHabitat("Texas Reptile Zoo", 30, naturalFeatures, "Texas", 36, 96);

    naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.DESERT);
    naturalFeatures.add(NaturalFeatures.ROCKS);
    reptileHouse.createHabitat("Mojave Desert", 30, naturalFeatures, "Nevada", 44, 101);

    naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.POND);
    naturalFeatures.add(NaturalFeatures.FLOWING_WATER);
    reptileHouse.createHabitat("North Carolina Zoo", 30, naturalFeatures, "North Carolina", 30, 92);

    naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.ROCKS);
    naturalFeatures.add(NaturalFeatures.FLOWING_WATER);
    reptileHouse.createHabitat("Outdoor Alabama", 30, naturalFeatures, "Alabama", 38, 88);
  }

  /**
   * Test method for addAnimal functionality of the Reptile House.
   */
  @Test
  public final void testAddAnimalTrue() {
    List<NaturalFeatures> naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.TREE_BRANCHES);
    naturalFeatures.add(NaturalFeatures.FLOWING_WATER);
    naturalFeatures.add(NaturalFeatures.GRASS);
    reptileHouse.createHabitat("Texas Reptile Zoo", 30, naturalFeatures, "Texas", 36, 96);

    naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.DESERT);
    naturalFeatures.add(NaturalFeatures.ROCKS);
    reptileHouse.createHabitat("Mojave Desert", 30, naturalFeatures, "Nevada", 44, 101);

    naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.POND);
    naturalFeatures.add(NaturalFeatures.FLOWING_WATER);
    reptileHouse.createHabitat("North Carolina Zoo", 30, naturalFeatures, "North Carolina", 30, 92);

    Characteristics characteristics = new CharacteristicsImpl(
        "Desert tortoises dig underground burrows "
            + "in order to hide from the sun in the deep desert.",
        AnimalSize.MEDIUM);
    Indicators indicators = new IndicatorsImpl(false, false, false, true);

    assertEquals(true, reptileHouse.addAnimal("Desert Tortoise", "REPTILE", characteristics, 75,
        100, NaturalFeatures.DESERT, indicators));
  }

  /**
   * Test method for addAnimal functionality of the Reptile House.
   */
  @Test
  public final void testAddAnimalFalse() {
    Characteristics characteristics = new CharacteristicsImpl(
        "Desert tortoises dig underground burrows "
            + "in order to hide from the sun in the deep desert.",
        AnimalSize.MEDIUM);
    Indicators indicators = new IndicatorsImpl(false, false, false, true);
    assertEquals(false, reptileHouse.addAnimal("Desert Tortoise", "REPTILE", characteristics, 75,
        100, NaturalFeatures.DESERT, indicators));
  }

  /**
   * Test method for addAnimal functionality of the Reptile House.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAddAnimalInvalidIndicators() {
    Characteristics characteristics = new CharacteristicsImpl(
        "Desert tortoises dig underground burrows "
            + "in order to hide from the sun in the deep desert.",
        AnimalSize.MEDIUM);
    reptileHouse.addAnimal("Desert Tortoise", "REPTILE", characteristics, 75, 100,
        NaturalFeatures.DESERT, null);
  }

  /**
   * Test method for addAnimal functionality of the Reptile House.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAddAnimalExtinctReptile() {
    Characteristics characteristics = new CharacteristicsImpl(
        "Desert tortoises dig underground burrows "
            + "in order to hide from the sun in the deep desert.",
        AnimalSize.MEDIUM);
    Indicators indicators = new IndicatorsImpl(false, false, true, true);
    reptileHouse.addAnimal("Desert Tortoise", "REPTILE", characteristics, 75, 100,
        NaturalFeatures.DESERT, indicators);
  }

  /**
   * Test method for addAnimal functionality of the Reptile House.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAddAnimalExtinctAmphibian() {
    Characteristics characteristics = new CharacteristicsImpl(
        "Gray treefrogs have a white spot beneath each eye and "
            + "a dark stripe from the rear of the eyes to the front of the legs.",
        AnimalSize.SMALL);
    Indicators indicators = new IndicatorsImpl(true, false, true, false);
    reptileHouse.addAnimal("Gray Treefrog", "AMPHIBIAN", characteristics, 65, 80,
        NaturalFeatures.TREE_BRANCHES, indicators);
  }

  /**
   * Test method for
   * {@link reptilehouse.ReptileHouseImpl#reportNaturalFeatures()}.
   */
  @Test
  public final void testReportNaturalFeatures() {
    List<NaturalFeatures> naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.TREE_BRANCHES);
    naturalFeatures.add(NaturalFeatures.FLOWING_WATER);
    naturalFeatures.add(NaturalFeatures.GRASS);
    reptileHouse.createHabitat("Texas Reptile Zoo", 30, naturalFeatures, "Texas", 36, 96);

    naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.DESERT);
    naturalFeatures.add(NaturalFeatures.ROCKS);
    reptileHouse.createHabitat("Mojave Desert", 30, naturalFeatures, "Nevada", 44, 101);

    naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.POND);
    naturalFeatures.add(NaturalFeatures.FLOWING_WATER);
    reptileHouse.createHabitat("North Carolina Zoo", 30, naturalFeatures, "North Carolina", 30, 92);
    String expected = "Natural Features -- \n" + "Natural Feature: DESERT: \n"
        + "Habitat Mojave Desert, Maximum space available: 30\n"
        + "Natural Feature: FLOWING_WATER: \n"
        + "Habitat Texas Reptile Zoo, Maximum space available: 30\n"
        + "Habitat North Carolina Zoo, Maximum space available: 30\n" + "Natural Feature: GRASS: \n"
        + "Habitat Texas Reptile Zoo, Maximum space available: 30\n" + "Natural Feature: POND: \n"
        + "Habitat North Carolina Zoo, Maximum space available: 30\n" + "Natural Feature: ROCKS: \n"
        + "Habitat Mojave Desert, Maximum space available: 30\n"
        + "Natural Feature: TREE_BRANCHES: \n"
        + "Habitat Texas Reptile Zoo, Maximum space available: 30\n";

    assertEquals(expected, reptileHouse.reportNaturalFeatures());
  }

  /**
   * Test method for {@link reptilehouse.ReptileHouseImpl#lookUpHabitat(String)}.
   */
  @Test
  public final void testLookUpHabitatEmpty() {
    String expected = "Species REPTILE currently not inhabiting any habitat.";
    assertEquals(expected, reptileHouse.lookUpHabitat("REPTILE"));
  }

  /**
   * Test method for {@link reptilehouse.ReptileHouseImpl#lookUpHabitat(String)}.
   */
  @Test
  public final void testLookUpHabitatWithOneAnimal() {
    List<NaturalFeatures> naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.TREE_BRANCHES);
    naturalFeatures.add(NaturalFeatures.FLOWING_WATER);
    naturalFeatures.add(NaturalFeatures.GRASS);
    reptileHouse.createHabitat("Texas Reptile Zoo", 30, naturalFeatures, "Texas", 36, 96);

    naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.DESERT);
    naturalFeatures.add(NaturalFeatures.ROCKS);
    reptileHouse.createHabitat("Mojave Desert", 30, naturalFeatures, "Nevada", 44, 101);

    naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.POND);
    naturalFeatures.add(NaturalFeatures.FLOWING_WATER);
    reptileHouse.createHabitat("North Carolina Zoo", 30, naturalFeatures, "North Carolina", 30, 92);

    Characteristics characteristics = new CharacteristicsImpl(
        "Desert tortoises dig underground burrows "
            + "in order to hide from the sun in the deep desert.",
        AnimalSize.MEDIUM);
    Indicators indicators = new IndicatorsImpl(false, false, false, true);
    reptileHouse.addAnimal("Desert Tortoise", "REPTILE", characteristics, 75, 100,
        NaturalFeatures.DESERT, indicators);
    String expected = "Habitat(s) that house REPTILE are: \n" + "Mojave Desert\n";
    assertEquals(expected, reptileHouse.lookUpHabitat("REPTILE"));
  }

  /**
   * Test method for
   * {@link reptilehouse.ReptileHouseImpl#printSignForHabitat(String)}.
   */
  @Test
  public final void testPrintSignForHabitat() {
    List<NaturalFeatures> naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.TREE_BRANCHES);
    naturalFeatures.add(NaturalFeatures.FLOWING_WATER);
    naturalFeatures.add(NaturalFeatures.GRASS);
    reptileHouse.createHabitat("Texas Reptile Zoo", 30, naturalFeatures, "Texas", 36, 96);

    naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.DESERT);
    naturalFeatures.add(NaturalFeatures.ROCKS);
    reptileHouse.createHabitat("Mojave Desert", 30, naturalFeatures, "Nevada", 44, 101);

    naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.POND);
    naturalFeatures.add(NaturalFeatures.FLOWING_WATER);
    reptileHouse.createHabitat("North Carolina Zoo", 30, naturalFeatures, "North Carolina", 30, 92);

    Characteristics characteristics = new CharacteristicsImpl(
        "Desert tortoises dig underground burrows "
            + "in order to hide from the sun in the deep desert.",
        AnimalSize.MEDIUM);
    Indicators indicators = new IndicatorsImpl(false, false, false, true);
    reptileHouse.addAnimal("Desert Tortoise", "REPTILE", characteristics, 75, 100,
        NaturalFeatures.DESERT, indicators);

    String expected = "Mojave Desert\n" + "Type of Species in habitat - REPTILE\n"
        + "Total number of Species currently inhabiting - 1\n"
        + "Species name: Desert Tortoise, Description: Desert tortoises dig underground burrows "
        + "" + "in order to hide from the sun in the deep desert., "
        + "Size: MEDIUM, Poisonous: false, Endangered: false, Extinct: false, "
        + "Can live with other species: true, Frequency - 1\n";

    assertEquals(expected, reptileHouse.printSignForHabitat("Mojave Desert"));
  }

  /**
   * Test method for {@link reptilehouse.ReptileHouseImpl#mapAllHabitats()}.
   */
  @Test
  public final void testMapAllHabitats() {
    List<NaturalFeatures> naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.TREE_BRANCHES);
    naturalFeatures.add(NaturalFeatures.FLOWING_WATER);
    naturalFeatures.add(NaturalFeatures.GRASS);
    reptileHouse.createHabitat("Texas Reptile Zoo", 30, naturalFeatures, "Texas", 36, 96);

    naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.DESERT);
    naturalFeatures.add(NaturalFeatures.ROCKS);
    reptileHouse.createHabitat("Mojave Desert", 30, naturalFeatures, "Nevada", 44, 101);

    naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.POND);
    naturalFeatures.add(NaturalFeatures.FLOWING_WATER);
    reptileHouse.createHabitat("North Carolina Zoo", 30, naturalFeatures, "North Carolina", 30, 92);

    Characteristics characteristics = new CharacteristicsImpl(
        "Desert tortoises dig underground burrows "
            + "in order to hide from the sun in the deep desert.",
        AnimalSize.MEDIUM);
    Indicators indicators = new IndicatorsImpl(false, false, false, true);
    reptileHouse.addAnimal("Desert Tortoise", "REPTILE", characteristics, 75, 100,
        NaturalFeatures.DESERT, indicators);

    String expected = "Location: North Carolina -- Name: North Carolina Zoo, "
        + "Natural Features: [POND, FLOWING_WATER], Species: []\n" + "\n"
        + "Location: Texas -- Name: Texas Reptile Zoo, "
        + "Natural Features: [TREE_BRANCHES, FLOWING_WATER, GRASS], Species: []\n" + "\n"
        + "Location: Nevada -- Name: Mojave Desert, "
        + "Natural Features: [DESERT, ROCKS], Species: [Desert Tortoise]\n" + "\n";

    assertEquals(expected, reptileHouse.mapAllHabitats());
  }

  /**
   * Test method for {@link reptilehouse.ReptileHouseImpl#indexOfSpecies()}.
   */
  @Test
  public final void testIndexOfSpecies() {
    List<NaturalFeatures> naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.TREE_BRANCHES);
    naturalFeatures.add(NaturalFeatures.FLOWING_WATER);
    naturalFeatures.add(NaturalFeatures.GRASS);
    reptileHouse.createHabitat("Texas Reptile Zoo", 30, naturalFeatures, "Texas", 36, 96);

    naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.DESERT);
    naturalFeatures.add(NaturalFeatures.ROCKS);
    reptileHouse.createHabitat("Mojave Desert", 30, naturalFeatures, "Nevada", 44, 101);

    naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.POND);
    naturalFeatures.add(NaturalFeatures.FLOWING_WATER);
    reptileHouse.createHabitat("North Carolina Zoo", 30, naturalFeatures, "North Carolina", 30, 92);

    Characteristics characteristics = new CharacteristicsImpl(
        "Desert tortoises dig underground burrows "
            + "in order to hide from the sun in the deep desert.",
        AnimalSize.MEDIUM);
    Indicators indicators = new IndicatorsImpl(false, false, false, true);
    reptileHouse.addAnimal("Desert Tortoise", "REPTILE", characteristics, 75, 100,
        NaturalFeatures.DESERT, indicators);

    String expected = "\nSpecies: Desert Tortoise, Location(s): [Nevada]";

    assertEquals(expected, reptileHouse.indexOfSpecies());
  }

}
