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
import reptilehouse.Reptile;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which consists of sample habitats that can be used in the test classes.
 * 
 * @author Jaswin Gumpella
 *
 */
public class SampleData {

  Habitat texasHabitat;// grayTreefrog
  Habitat nevadaHabitat;// desertTortoise
  Habitat northCarolinaHabitat;// americanAlligator
  Habitat alabamaHabitat;// hellbenderSalamander
  Animal grayTreefrog;
  Animal desertTortoise;
  Animal americanAlligator;
  Animal hellbenderSalamander;
  Animal fenceLizard;
  Animal axylotl;
  Animal tRex;

  /**
   * Constructor for the SampleData class in which the sample animals and habitats
   * are initialized.
   */
  public SampleData() {

    List<NaturalFeatures> naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.TREE_BRANCHES);
    naturalFeatures.add(NaturalFeatures.FLOWING_WATER);
    naturalFeatures.add(NaturalFeatures.GRASS);
    this.texasHabitat = new HabitatImpl("Texas Reptile Zoo", 30, naturalFeatures, "Texas", 36, 96);

    naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.DESERT);
    naturalFeatures.add(NaturalFeatures.ROCKS);
    this.nevadaHabitat = new HabitatImpl("Mojave Desert", 30, naturalFeatures, "Nevada", 44, 101);

    naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.POND);
    naturalFeatures.add(NaturalFeatures.FLOWING_WATER);
    this.northCarolinaHabitat = new HabitatImpl("North Carolina Zoo", 30, naturalFeatures,
        "North Carolina", 30, 92);

    naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.ROCKS);
    naturalFeatures.add(NaturalFeatures.FLOWING_WATER);
    this.alabamaHabitat = new HabitatImpl("Outdoor Alabama", 30, naturalFeatures, "Alabama", 38,
        88);

    Characteristics characteristics = new CharacteristicsImpl(
        "Gray treefrogs have a white spot beneath each eye and "
            + "a dark stripe from the rear of the eyes to the front of the legs.",
        AnimalSize.SMALL);
    Indicators indicators = new IndicatorsImpl(true, false, false, false);
    this.grayTreefrog = new Amphibian("Gray Treefrog", characteristics, 65, 80,
        NaturalFeatures.TREE_BRANCHES, indicators);

    characteristics = new CharacteristicsImpl("Desert tortoises dig underground burrows "
        + "in order to hide from the sun in the deep desert.", AnimalSize.MEDIUM);
    indicators = new IndicatorsImpl(false, false, false, true);
    this.desertTortoise = new Reptile("Desert Tortoise", characteristics, 75, 100,
        NaturalFeatures.DESERT, indicators);

    characteristics = new CharacteristicsImpl(
        "American alligator is capable of biting through a turtle's shell"
            + " or a moderately sized mammal bone.",
        AnimalSize.LARGE);
    indicators = new IndicatorsImpl(false, false, false, false);
    this.americanAlligator = new Reptile("American Alligator", characteristics, 82, 92,
        NaturalFeatures.POND, indicators);

    characteristics = new CharacteristicsImpl("Hellbenders average up to about 2 ft in length,"
        + " making them the largest amphibian in North America.", AnimalSize.MEDIUM);
    indicators = new IndicatorsImpl(false, true, false, true);
    this.hellbenderSalamander = new Amphibian("Hellbender Salamander", characteristics, 45, 80,
        NaturalFeatures.FLOWING_WATER, indicators);

    characteristics = new CharacteristicsImpl(
        "10 - 18.5 cm. A member of the spiny lizard family, also known as a blue belly.",
        AnimalSize.SMALL);
    indicators = new IndicatorsImpl(false, false, false, true);
    this.fenceLizard = new Reptile("Fence Lizard", characteristics, 81, 99, NaturalFeatures.ROCKS,
        indicators);

    characteristics = new CharacteristicsImpl(
        "15 to 45 cm. Also known as the Mexican Walking Fish, "
            + "the axylotl is a salamander with external gills. They are oddly cute.",
        AnimalSize.SMALL);
    indicators = new IndicatorsImpl(false, true, false, true);
    this.axylotl = new Reptile("Axylotl", characteristics, 59, 64, NaturalFeatures.FLOWING_WATER,
        indicators);

    characteristics = new CharacteristicsImpl(
        "King of the Tyrant Lizards. They grew very large. "
            + "Known for not being able to blow its nose due to it's short arms.  Very ornery.",
        AnimalSize.LARGE);
    indicators = new IndicatorsImpl(false, true, false, true);
    this.tRex = new Reptile("T-Rex", characteristics, 86, 113, NaturalFeatures.DESERT, indicators);

    this.texasHabitat.addAnimal(this.grayTreefrog);
    this.nevadaHabitat.addAnimal(this.desertTortoise);
    this.northCarolinaHabitat.addAnimal(this.americanAlligator);
    this.alabamaHabitat.addAnimal(hellbenderSalamander);
  }

  /**
   * Method used to get the Texas habitat.
   * 
   * @return the texasHabitat
   */
  public Habitat getTexasHabitat() {
    return texasHabitat;
  }

  /**
   * Method used to get the Nevada habitat.
   * 
   * @return the nevadaHabitat
   */
  public Habitat getNevadaHabitat() {
    return nevadaHabitat;
  }

  /**
   * Method used to get the North Carolina habitat.
   * 
   * @return the northCarolinaHabitat
   */
  public Habitat getNorthCarolinaHabitat() {
    return northCarolinaHabitat;
  }

  /**
   * Method used to get the Alabama habitat.
   * 
   * @return the alabamaHabitat
   */
  public Habitat getAlabamaHabitat() {
    return alabamaHabitat;
  }

  /**
   * Method used to get the Gray Tree Frog animal.
   * 
   * @return the grayTreefrog
   */
  public Animal getGrayTreefrog() {
    return grayTreefrog;
  }

  /**
   * Method used to get the Desert Tortoise animal.
   * 
   * @return the desertTortoise
   */
  public Animal getDesertTortoise() {
    return desertTortoise;
  }

  /**
   * Method used to get the American Alligator animal.
   * 
   * @return the americanAlligator
   */
  public Animal getAmericanAlligator() {
    return americanAlligator;
  }

  /**
   * Method used to get the Hellbender Salamander animal.
   * 
   * @return the hellbenderSalamander
   */
  public Animal getHellbenderSalamander() {
    return hellbenderSalamander;
  }

  /**
   * Method used to get the Fence Lizard animal.
   * 
   * @return the fenceLizard
   */
  public Animal getFenceLizard() {
    return fenceLizard;
  }

  /**
   * Method used to get the Axylotl animal.
   * 
   * @return the axylotl
   */
  public Animal getAxylotl() {
    return axylotl;
  }

  /**
   * Method used to get the T-Rex animal.
   * 
   * @return the tRex
   */
  public Animal gettRex() {
    return tRex;
  }

}
