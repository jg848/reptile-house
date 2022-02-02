package reptilehouse;

import java.util.ArrayList;
import java.util.List;

/**
 * Driver class for the ReptileHouse implementation. Used to test the Reptile
 * House functionality.
 * 
 * @author Jaswin Gumpella
 *
 */
public class ReptileHouseDriver {

  static ReptileHouse reptileHouse;
  static Animal grayTreefrog;
  static Animal desertTortoise;
  static Animal americanAlligator;

  /**
   * Main method of the ReptileHouseBuilder class which is used to run and test
   * the ReptileHouse.
   * 
   * @param args which are the arguments for the main method.
   */
  public static void main(String[] args) {

    System.out.println("Running ReptileHouse.\nCreating reptile house of "
        + "size 100 square meters and can have a maximum of 3 habitats.");
    reptileHouse = new ReptileHouseImpl(100, 3);

    Characteristics characteristics1 = new CharacteristicsImpl(
        "Gray treefrogs have a white spot beneath each eye and "
            + "a dark stripe from the rear of the eyes to the front of the legs.",
        AnimalSize.SMALL);
    Indicators indicators = new IndicatorsImpl(true, false, false, false);
    grayTreefrog = new Amphibian("Gray Treefrog", characteristics1, 65, 80,
        NaturalFeatures.TREE_BRANCHES, indicators);

    Characteristics characteristics2 = new CharacteristicsImpl(
        "Desert tortoises dig underground burrows "
            + "in order to hide from the sun in the deep desert.",
        AnimalSize.MEDIUM);
    indicators = new IndicatorsImpl(false, false, false, true);
    desertTortoise = new Reptile("Desert Tortoise", characteristics2, 75, 100,
        NaturalFeatures.DESERT, indicators);

    Characteristics characteristics3 = new CharacteristicsImpl(
        "American alligator is capable of biting through a turtle's shell"
            + " or a moderately sized mammal bone.",
        AnimalSize.LARGE);
    indicators = new IndicatorsImpl(false, false, false, false);
    americanAlligator = new Reptile("American Alligator", characteristics3, 82, 92,
        NaturalFeatures.POND, indicators);

    System.out.println("\nCreating habitat 'Texas Reptile Zoo'.");
    List<NaturalFeatures> naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.TREE_BRANCHES);
    naturalFeatures.add(NaturalFeatures.FLOWING_WATER);
    naturalFeatures.add(NaturalFeatures.GRASS);
    System.out.println("Created habitat - "
        + reptileHouse.createHabitat("Texas Reptile Zoo", 30, naturalFeatures, "Texas", 36, 96));

    System.out.println("\nCreating habitat 'Mojave Desert'.");
    naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.DESERT);
    naturalFeatures.add(NaturalFeatures.ROCKS);
    System.out.println("Created habitat - "
        + reptileHouse.createHabitat("Mojave Desert", 30, naturalFeatures, "Nevada", 44, 101));

    System.out.println("\nCreating habitat 'North Carolina Zoo'.");
    naturalFeatures = new ArrayList<>();
    naturalFeatures.add(NaturalFeatures.POND);
    naturalFeatures.add(NaturalFeatures.FLOWING_WATER);
    System.out.println("Created habitat - " + reptileHouse.createHabitat("North Carolina Zoo", 30,
        naturalFeatures, "North Carolina", 30, 92));
    System.out.println("\nCalling method mapAllHabitats().\n" + reptileHouse.mapAllHabitats());

    System.out.println(
        "\nCalling method reportNaturalFeatures().\n" + reptileHouse.reportNaturalFeatures());

    System.out.println(
        "\nCalling method lookUpHabitat(\"REPTILE\").\n" + reptileHouse.lookUpHabitat("REPTILE"));

    System.out.println("\nCalling method lookUpHabitat(\"AMPHIBIAN\").\n"
        + reptileHouse.lookUpHabitat("AMPHIBIAN"));

    System.out.println("\nCalling method printSignForHabitat(\"Texas Reptile Zoo\").\n"
        + reptileHouse.printSignForHabitat("Texas Reptile Zoo"));

    System.out.println("\nCalling method printSignForHabitat(\"Mojave Desert\").\n"
        + reptileHouse.printSignForHabitat("Mojave Desert"));

    System.out.println("\nCalling method printSignForHabitat(\"North Carolina Zoo\").\n"
        + reptileHouse.printSignForHabitat("North Carolina Zoo"));

    System.out.println("\nAdding animal Gray Treefrog into Reptile House.");
    System.out.println("Added animal into habitat - " + reptileHouse.addAnimal("Gray Treefrog",
        "Amphibian", characteristics1, 65, 80, NaturalFeatures.TREE_BRANCHES, indicators));

    System.out.println("\nAdding animal Desert Tortoise into Reptile House.");
    System.out.println("Added animal into habitat - " + reptileHouse.addAnimal("Desert Tortoise",
        "Reptile", characteristics2, 75, 100, NaturalFeatures.DESERT, indicators));

    System.out.println("\nAdding animal American Alligator into Reptile House.");
    System.out.println("Added animal into habitat - " + reptileHouse.addAnimal("American Alligator",
        "Reptile", characteristics3, 82, 92, NaturalFeatures.POND, indicators));

    System.out.println(
        "\nCalling method reportNaturalFeatures().\n" + reptileHouse.reportNaturalFeatures());

    System.out.println(
        "\nCalling method lookUpHabitat(\"REPTILE\").\n" + reptileHouse.lookUpHabitat("REPTILE"));

    System.out.println("\nCalling method lookUpHabitat(\"AMPHIBIAN\").\n"
        + reptileHouse.lookUpHabitat("AMPHIBIAN"));

    System.out.println("\nCalling method printSignForHabitat(\"Texas Reptile Zoo\").\n"
        + reptileHouse.printSignForHabitat("Texas Reptile Zoo"));

    System.out.println("\nCalling method printSignForHabitat(\"Mojave Desert\").\n"
        + reptileHouse.printSignForHabitat("Mojave Desert"));

    System.out.println("\nCalling method printSignForHabitat(\"North Carolina Zoo\").\n"
        + reptileHouse.printSignForHabitat("North Carolina Zoo"));

    System.out.println("\nCalling method indexOfSpecies().\n" + reptileHouse.indexOfSpecies());
  }
}
