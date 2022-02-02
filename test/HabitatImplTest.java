import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import reptilehouse.Amphibian;
import reptilehouse.Animal;
import reptilehouse.AnimalSize;
import reptilehouse.Characteristics;
import reptilehouse.CharacteristicsImpl;
import reptilehouse.Habitat;
import reptilehouse.HabitatImpl;
import reptilehouse.Indicators;
import reptilehouse.IndicatorsImpl;
import reptilehouse.NaturalFeatures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Test class for HabitatImpl class which implements the Habitat interface. Used
 * to test a single habitat in the Reptile House.
 * 
 * @author Jaswin Gumpella
 *
 */
public class HabitatImplTest {

  Habitat habitat;
  List<NaturalFeatures> naturalFeatures;
  Animal animal;

  /**
   * Method used to setup the required instances for the test class.
   * 
   * @throws IllegalArgumentException in case of any exception.
   */
  @Before
  public void setUp() throws IllegalArgumentException {
    naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.TREE_BRANCHES);
    naturalFeatures.add(NaturalFeatures.FLOWING_WATER);
    naturalFeatures.add(NaturalFeatures.GRASS);
    habitat = new HabitatImpl("Texas Reptile Zoo", 30, naturalFeatures, "Texas", 36, 96);

    Characteristics characteristics = new CharacteristicsImpl(
        "Gray treefrogs have a white spot beneath each eye and "
            + "a dark stripe from the rear of the eyes to the front of the legs.",
        AnimalSize.SMALL);
    Indicators indicators = new IndicatorsImpl(true, false, false, false);
    this.animal = new Amphibian("Gray Treefrog", characteristics, 65, 80,
        NaturalFeatures.TREE_BRANCHES, indicators);
  }

  /**
   * Test method for
   * {@link reptilehouse.HabitatImpl#HabitatImpl(String, int, List, String, int, int)}.
   */
  @Test
  public final void testHabitatImpl() {
    habitat = new HabitatImpl("Texas Reptile Zoo", 30, naturalFeatures, "Texas", 36, 96);
    assertEquals(HabitatImpl.class, habitat.getClass());
  }

  /**
   * Test method for
   * {@link reptilehouse.HabitatImpl#HabitatImpl(String, int, List, String, int, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testHabitatImplInvalidHabitatName() {
    new HabitatImpl("", 30, naturalFeatures, "Texas", 36, 96);
  }

  /**
   * Test method for
   * {@link reptilehouse.HabitatImpl#HabitatImpl(String, int, List, String, int, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testHabitatImplInvalidHabitatSize() {
    new HabitatImpl("Texas Reptile Zoo", -30, naturalFeatures, "Texas", 36, 96);
  }

  /**
   * Test method for
   * {@link reptilehouse.HabitatImpl#HabitatImpl(String, int, List, String, int, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testHabitatImplInvalidHabitatNaturalFeatures() {
    new HabitatImpl("Texas Reptile Zoo", 30, null, "Texas", 36, 96);
  }

  /**
   * Test method for
   * {@link reptilehouse.HabitatImpl#HabitatImpl(String, int, List, String, int, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testHabitatImplInvalidHabitatLocation() {
    new HabitatImpl("Texas Reptile Zoo", 30, naturalFeatures, "", 36, 96);
  }

  /**
   * Test method for
   * {@link reptilehouse.HabitatImpl#HabitatImpl(String, int, List, String, int, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testHabitatImplInvalidHabitatTemperatures() {
    new HabitatImpl("Texas Reptile Zoo", 30, naturalFeatures, "Texas", 36, 16);
  }

  /**
   * Test method for
   * {@link reptilehouse.HabitatImpl#checkNaturalFeatures(reptilehouse.NaturalFeatures)}.
   */
  @Test
  public final void testCheckNaturalFeaturesTrue() {
    assertEquals(true, habitat.checkNaturalFeatures(NaturalFeatures.FLOWING_WATER));
  }

  /**
   * Test method for
   * {@link reptilehouse.HabitatImpl#checkNaturalFeatures(reptilehouse.NaturalFeatures)}.
   */
  @Test
  public final void testCheckNaturalFeaturesFalse() {
    assertEquals(false, habitat.checkNaturalFeatures(NaturalFeatures.DESERT));
  }

  /**
   * Test method for
   * {@link reptilehouse.HabitatImpl#addNaturalFeature(reptilehouse.NaturalFeatures)}.
   */
  @Test
  public final void testAddNaturalFeatureTrue() {
    naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.TREE_BRANCHES);
    naturalFeatures.add(NaturalFeatures.FLOWING_WATER);
    habitat = new HabitatImpl("Texas Reptile Zoo", 30, naturalFeatures, "Texas", 36, 96);
    assertEquals(true, habitat.addNaturalFeature(NaturalFeatures.GRASS));
  }

  /**
   * Test method for
   * {@link reptilehouse.HabitatImpl#addNaturalFeature(reptilehouse.NaturalFeatures)}.
   */
  @Test
  public final void testAddNaturalFeatureFalse() {
    naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.TREE_BRANCHES);
    naturalFeatures.add(NaturalFeatures.FLOWING_WATER);
    naturalFeatures.add(NaturalFeatures.FALLEN_LOGS);
    habitat = new HabitatImpl("Texas Reptile Zoo", 30, naturalFeatures, "Texas", 36, 96);
    assertEquals(false, habitat.addNaturalFeature(NaturalFeatures.GRASS));
  }

  /**
   * Test method for {@link reptilehouse.HabitatImpl#checkIfEmpty()}.
   */
  @Test
  public final void testCheckIfEmptyTrue() {
    assertEquals(true, habitat.checkIfEmpty());
  }

  /**
   * Test method for {@link reptilehouse.HabitatImpl#checkIfEmpty()}.
   */
  @Test
  public final void testCheckIfEmptyFalse() {
    habitat.addAnimal(animal);
    assertEquals(false, habitat.checkIfEmpty());
  }

  /**
   * Test method for
   * {@link reptilehouse.HabitatImpl#checkTemperatureRange(int, int)}.
   */
  @Test
  public final void testCheckTemperatureRangeTrue() {
    assertEquals(true, habitat.checkTemperatureRange(40, 60));
  }

  /**
   * Test method for
   * {@link reptilehouse.HabitatImpl#checkTemperatureRange(int, int)}.
   */
  @Test
  public final void testCheckTemperatureRangeFalse() {
    assertEquals(false, habitat.checkTemperatureRange(0, 60));
  }

  /**
   * Test method for
   * {@link reptilehouse.HabitatImpl#checkSizeAvailable(reptilehouse.AnimalSize)}.
   */
  @Test
  public final void testCheckSizeAvailableTrueLarge() {
    assertEquals(true, habitat.checkSizeAvailable(AnimalSize.LARGE));
  }

  /**
   * Test method for
   * {@link reptilehouse.HabitatImpl#checkSizeAvailable(reptilehouse.AnimalSize)}.
   */
  @Test
  public final void testCheckSizeAvailableTrueMedium() {
    assertEquals(true, habitat.checkSizeAvailable(AnimalSize.MEDIUM));
  }

  /**
   * Test method for
   * {@link reptilehouse.HabitatImpl#checkSizeAvailable(reptilehouse.AnimalSize)}.
   */
  @Test
  public final void testCheckSizeAvailableTrueSmall() {
    assertEquals(true, habitat.checkSizeAvailable(AnimalSize.SMALL));
  }

  /**
   * Test method for
   * {@link reptilehouse.HabitatImpl#checkSizeAvailable(reptilehouse.AnimalSize)}.
   */
  @Test
  public final void testCheckSizeAvailableFalseSmall() {
    for (int i = 0; i < 30; i++) {
      habitat.addAnimal(animal);
    }
    assertEquals(false, habitat.checkSizeAvailable(AnimalSize.SMALL));
  }

  /**
   * Test method for
   * {@link reptilehouse.HabitatImpl#checkSizeAvailable(reptilehouse.AnimalSize)}.
   */
  @Test
  public final void testCheckSizeAvailableFalseMedium() {
    for (int i = 0; i < 30; i++) {
      habitat.addAnimal(animal);
    }
    assertEquals(false, habitat.checkSizeAvailable(AnimalSize.MEDIUM));
  }

  /**
   * Test method for
   * {@link reptilehouse.HabitatImpl#checkSizeAvailable(reptilehouse.AnimalSize)}.
   */
  @Test
  public final void testCheckSizeAvailableFalseLarge() {
    for (int i = 0; i < 30; i++) {
      habitat.addAnimal(animal);
    }
    assertEquals(false, habitat.checkSizeAvailable(AnimalSize.LARGE));
  }

  /**
   * Test method for {@link reptilehouse.HabitatImpl#checkHabitatType(String)}.
   */
  @Test
  public final void testCheckHabitatTypeTrue() {
    habitat.addAnimal(animal);
    assertEquals(true, habitat.checkHabitatType(animal.getSpecies()));
  }

  /**
   * Test method for {@link reptilehouse.HabitatImpl#checkHabitatType(String)}.
   */
  @Test
  public final void testCheckHabitatTypeFalse() {
    assertEquals(false, habitat.checkHabitatType(animal.getSpecies()));
  }

  /**
   * Test method for {@link reptilehouse.HabitatImpl#checkCoLive()}.
   */
  @Test
  public final void testCheckCoLiveTrue() {
    assertEquals(true, habitat.checkCoLive());
  }

  /**
   * Test method for {@link reptilehouse.HabitatImpl#checkCoLive()}.
   */
  @Test
  public final void testCheckCoLiveFalse() {
    habitat.addAnimal(animal);
    assertEquals(false, habitat.checkCoLive());
  }

  /**
   * Test method for {@link reptilehouse.HabitatImpl#checkAnimal(String)}.
   */
  @Test
  public final void testCheckAnimalTrue() {
    habitat.addAnimal(animal);
    assertEquals(true, habitat.checkAnimal(animal.getAnimalName()));
  }

  /**
   * Test method for {@link reptilehouse.HabitatImpl#checkAnimal(String)}.
   */
  @Test
  public final void testCheckAnimalFalse() {
    assertEquals(false, habitat.checkAnimal(animal.getAnimalName()));
  }

  /**
   * Test method for
   * {@link reptilehouse.HabitatImpl#addAnimal(reptilehouse.Animal)}.
   */
  @Test
  public final void testAddAnimal() {
    assertEquals(true, habitat.addAnimal(animal));
  }

  /**
   * Test method for {@link reptilehouse.HabitatImpl#getNaturalFeatures()}.
   */
  @Test
  public final void testGetNaturalFeatures() {
    List<NaturalFeatures> expected = new ArrayList<>();
    expected.add(NaturalFeatures.TREE_BRANCHES);
    expected.add(NaturalFeatures.FLOWING_WATER);
    expected.add(NaturalFeatures.GRASS);
    assertEquals(expected, habitat.getNaturalFeatures());
  }

  /**
   * Test method for
   * {@link reptilehouse.HabitatImpl#getNaturalFeaturesSize(reptilehouse.NaturalFeatures)}.
   */
  @Test
  public final void testGetNaturalFeaturesSize() {
    String expected = "Maximum space available: 30";
    assertEquals(expected, habitat.getNaturalFeaturesSize(NaturalFeatures.TREE_BRANCHES));
  }

  /**
   * Test method for {@link reptilehouse.HabitatImpl#getHabitatName()}.
   */
  @Test
  public final void testGetHabitatName() {
    String expected = "Texas Reptile Zoo";
    assertEquals(expected, habitat.getHabitatName());
  }

  /**
   * Test method for {@link reptilehouse.HabitatImpl#toString()}.
   */
  @Test
  public final void testToString() {
    String expected = "Texas Reptile Zoo" + "\n"
        + "Type of Species in habitat - Species Type not assigned." + "\n"
        + "Total number of Species currently inhabiting - 0" + "\n";
    assertEquals(expected, habitat.toString());
  }

  /**
   * Test method for {@link reptilehouse.HabitatImpl#getHabitatLocation()}.
   */
  @Test
  public final void testGetHabitatLocation() {
    assertEquals("Texas", habitat.getHabitatLocation());
  }

  /**
   * Test method for {@link reptilehouse.HabitatImpl#getHabitatMapDetails()}.
   */
  @Test
  public final void testGetHabitatMapDetails() {
    String expected = "Name: Texas Reptile Zoo, "
        + "Natural Features: [TREE_BRANCHES, FLOWING_WATER, GRASS], Species: []";
    assertEquals(expected, habitat.getHabitatMapDetails());
  }

  /**
   * Test method for {@link reptilehouse.HabitatImpl#getSpeciesMap()}.
   */
  @Test
  public final void testGetSpeciesMap() {
    habitat.addAnimal(animal);
    Map<String, String> expected = new HashMap<>();
    expected.put("Gray Treefrog", "Texas");
    assertEquals(expected, habitat.getSpeciesMap());
  }

}
