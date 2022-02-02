package reptilehouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Implementation class for the Habitat interface which contains the
 * implementation for the functionalities mentioned in the interface. Represents
 * a single habitat inside a reptile house.
 * 
 * @author Jaswin Gumpella
 *
 */
public class HabitatImpl implements Habitat {

  private String habitatName;
  private int habitatSize = 0;
  private List<NaturalFeatures> naturalFeaturesList = new ArrayList<>();
  private String location;
  private int minimumTemperature = 0;
  private int maximumTemperature = 0;
  private String habitatType;
  private List<Animal> animalsList = new ArrayList<>();

  /**
   * Constructor for the implementation class of Habitat interface. Takes input of
   * the habitat name, habitat size, list of upto 3 natural featues, habitat
   * location, minimum temperature of the habitat and maximum temperature of the
   * habitat.
   * 
   * @param name            which represents the name of the habitat.
   * @param size            which represents the size of the habitat.
   * @param naturalFeatures which represents list of upto 3 natural features of
   *                        the habitat.
   * @param loc             which represents the location of the habitat.
   * @param minTemperature  which represents the minimum temperature of the
   *                        habitat.
   * @param maxTemperature  which represents the maximum temperature of the
   *                        habitat.
   */
  public HabitatImpl(String name, int size, List<NaturalFeatures> naturalFeatures, String loc,
      int minTemperature, int maxTemperature) {
    if (null != name && !name.isEmpty()) {
      this.habitatName = name;
    } else {
      throw new IllegalArgumentException("Name of the habitat cannot be empty.");
    }
    if (size > 0) {
      this.habitatSize = size;
    } else {
      throw new IllegalArgumentException("Habitat size cannot be 0 or negative");
    }

    if (null != naturalFeatures && !naturalFeatures.isEmpty() && naturalFeatures.size() <= 3) {
      this.naturalFeaturesList.addAll(naturalFeatures);
    } else {
      throw new IllegalArgumentException("Habitat cannot have 0 or more than 3 natural features.");
    }

    if (null != loc && !loc.isEmpty()) {
      this.location = loc;
    } else {
      throw new IllegalArgumentException("Location cannot be empty.");
    }

    if (minTemperature < maxTemperature) {
      this.minimumTemperature = minTemperature;
      this.maximumTemperature = maxTemperature;
    } else {
      throw new IllegalArgumentException(
          "Minimum temperature cannot be greater than Maximum temperature.");
    }
  }

  @Override
  public boolean checkNaturalFeatures(NaturalFeatures animalNaturalFeature) {
    return this.naturalFeaturesList.contains(animalNaturalFeature);
  }

  @Override
  public boolean addNaturalFeature(NaturalFeatures animalNaturalFeature) {

    if (this.naturalFeaturesList.size() < 3) {
      this.naturalFeaturesList.add(animalNaturalFeature);
      return true;
    }
    return false;
  }

  @Override
  public boolean checkIfEmpty() {
    return this.animalsList.isEmpty();
  }

  @Override
  public boolean checkTemperatureRange(int minTemp, int maxTemp) {

    boolean inRange = false;
    if (minTemp >= this.minimumTemperature && minTemp <= this.maximumTemperature
        && maxTemp >= this.minimumTemperature && maxTemp <= this.maximumTemperature) {
      inRange = true;
    }
    return inRange;
  }

  @Override
  public boolean checkSizeAvailable(AnimalSize animalSize) {
    return ((animalSize.equals(AnimalSize.LARGE) && habitatSize >= 10)
        || (animalSize.equals(AnimalSize.MEDIUM) && habitatSize >= 5)
        || (animalSize.equals(AnimalSize.SMALL) && habitatSize >= 1));
  }

  @Override
  public boolean checkHabitatType(String species) {
    if (null != this.habitatType && !habitatType.isEmpty()) {
      return this.habitatType.equalsIgnoreCase(species);
    } else {
      return false;
    }
  }

  @Override
  public boolean checkCoLive() {
    boolean check = false;
    if (animalsList.isEmpty()) {
      return true;
    }
    Set<Animal> distinct = new HashSet<>(animalsList);
    for (Animal animal : distinct) {
      if (animal.isCoLive()) {
        check = true;
      } else {
        check = false;
        break;
      }
    }
    return check;
  }

  @Override
  public boolean checkAnimal(String animal) {
    boolean check = false;
    if (null != animalsList && !animalsList.isEmpty()) {
      Set<Animal> distinct = new HashSet<>(animalsList);
      if (distinct.size() == 1
          && this.animalsList.get(0).getAnimalName().equalsIgnoreCase(animal)) {
        check = true;
      }
    }
    return check;
  }

  @Override
  public boolean addAnimal(Animal animal) {
    if (this.animalsList.isEmpty()) {
      this.habitatType = animal.getSpecies();
    }
    this.animalsList.add(animal);
    habitatSize -= animal.getAnimalSize();
    return true;
  }

  @Override
  public List<NaturalFeatures> getNaturalFeatures() {
    return this.naturalFeaturesList;
  }

  @Override
  public String getNaturalFeaturesSize(NaturalFeatures naturalFeature) {
    StringBuilder builder = new StringBuilder();

    if (naturalFeaturesList.contains(naturalFeature)) {
      builder.append("Maximum space available: ").append(habitatSize);
    }
    return builder.toString();
  }

  @Override
  public String getHabitatName() {
    return this.habitatName;
  }

  /**
   * Method used to get a string with the name of the habitat, type of species in
   * the habitat, total number of species in the habitat, description of the
   * animals living in the habitat and their frequency.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(this.habitatName).append("\n");
    sb.append("Type of Species in habitat - ");
    if (null != this.habitatType) {
      sb.append(this.habitatType);
    } else {
      sb.append("Species Type not assigned.");
    }
    sb.append("\n");
    sb.append("Total number of Species currently inhabiting - ").append(this.animalsList.size())
        .append("\n");
    List<String> animalDescriptions = new ArrayList<>();
    for (int i = 0; i < animalsList.size(); i++) {
      animalDescriptions.add(animalsList.get(i).toString());
    }
    Set<String> distinct = new HashSet<>(animalDescriptions);
    for (String s : distinct) {
      sb.append(s + ", Frequency - " + Collections.frequency(animalDescriptions, s)).append("\n");
    }
    return sb.toString();
  }

  @Override
  public String getHabitatLocation() {
    return this.location;
  }

  @Override
  public String getHabitatMapDetails() {
    StringBuilder sb = new StringBuilder();

    sb.append("Name: ").append(this.habitatName).append(", ");
    sb.append("Natural Features: ").append(this.naturalFeaturesList).append(", ");
    sb.append("Species: ");
    List<String> speciesNames = new ArrayList<>();
    for (int i = 0; i < animalsList.size(); i++) {
      speciesNames.add(animalsList.get(i).toString().split(",")[0].split(":")[1].trim());
    }
    Set<String> distinct = new HashSet<>(speciesNames);
    sb.append(distinct.toString());

    return sb.toString();
  }

  @Override
  public Map<String, String> getSpeciesMap() {
    Map<String, String> species = new HashMap<>();

    for (int i = 0; i < animalsList.size(); i++) {
      species.put(animalsList.get(i).getAnimalName(), this.location);
    }

    return species;
  }

}
