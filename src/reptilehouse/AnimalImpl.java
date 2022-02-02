package reptilehouse;

/**
 * Abstract class which implements the Animal interface. Contains the common
 * functionalities for Reptile and Amphibian species types.
 * 
 * @author Jaswin Gumpella
 *
 */
abstract class AnimalImpl implements Animal {

  protected String name;
  protected Characteristics animalCharacteristics;
  protected int minimumTemperature = 0;
  protected int maximumTemperature = 0;
  protected NaturalFeatures animalNaturalFeature;
  protected Indicators animalIndicators;

  /**
   * Constructor of AnimalImpl class which is the implementation class of Animal
   * interface. Represents a single animal species. Takes input of animal name,
   * animal characteristics, minimum temperature, maximum temperature, preferred
   * natural feature and indicators of an animal.
   * 
   * @param animalName      which represents the name of the animal.
   * @param characteristics which represents the defining characteristics of an
   *                        animal like description and size of an animal.
   * @param minTemp         which represents the preferred minimum temperature of
   *                        an animal.
   * @param maxTemp         which represents the preferred maximum temperature of
   *                        an animal.
   * @param naturalFeature  which represents the preferred natural feature of an
   *                        animal.
   * @param indicators      which represents the indicators of animal like if it
   *                        is poisonous or not, endangered or not, extinct or not
   *                        and can live with other animal species or not.
   */
  protected AnimalImpl(String animalName, Characteristics characteristics, int minTemp, int maxTemp,
      NaturalFeatures naturalFeature, Indicators indicators) {

    if (null != animalName && !animalName.isEmpty()) {
      this.name = animalName;
    } else {
      throw new IllegalArgumentException("Animal name cannot be empty.");
    }
    if (null != characteristics) {
      this.animalCharacteristics = characteristics;
    } else {
      throw new IllegalArgumentException("Characteristics of animal not given.");
    }
    if (minTemp >= maxTemp) {
      throw new IllegalArgumentException(
          "Minimum temperature cannot be greater than or equal to Maximum temperature.");
    } else {
      this.minimumTemperature = minTemp;
      this.maximumTemperature = maxTemp;
    }
    if (null != naturalFeature && (naturalFeature.equals(NaturalFeatures.DESERT)
        || naturalFeature.equals(NaturalFeatures.FALLEN_LOGS)
        || naturalFeature.equals(NaturalFeatures.FLOWING_WATER)
        || naturalFeature.equals(NaturalFeatures.GRASS)
        || naturalFeature.equals(NaturalFeatures.LILY_PADS)
        || naturalFeature.equals(NaturalFeatures.POND)
        || naturalFeature.equals(NaturalFeatures.ROCKS)
        || naturalFeature.equals(NaturalFeatures.SALT_WATER)
        || naturalFeature.equals(NaturalFeatures.SANDY_BEACH)
        || naturalFeature.equals(NaturalFeatures.TREE_BRANCHES))) {
      this.animalNaturalFeature = naturalFeature;
    } else {
      throw new IllegalArgumentException("Invalid natural feature input.");
    }
    if (null != indicators) {
      this.animalIndicators = indicators;
    } else {
      throw new IllegalArgumentException("Invalid animal indicators input.");
    }
  }

  @Override
  public boolean checkAddAnimal(Habitat habitat) {

    boolean checkAdd = false;
    if (habitat.checkTemperatureRange(this.minimumTemperature, this.maximumTemperature)) {
      if (habitat.checkNaturalFeatures(this.animalNaturalFeature)) {
        checkAdd = habitat.checkIfEmpty();
        if (checkAdd) {
          return checkAdd;
        } else {
          if (habitat.checkSizeAvailable(this.animalCharacteristics.getAnimalSize())) {
            checkAdd = true;
          }
        }
        this.checkSpecies(habitat);
      } else {
        if (habitat.addNaturalFeature(this.animalNaturalFeature)) {
          checkAddAnimal(habitat);
        }
      }
    }
    return checkAdd;
  }

  @Override
  public boolean isCoLive() {
    return this.animalIndicators.isCoLive();
  }

  private boolean checkSpecies(Habitat habitat) {

    boolean checkAdd = false;
    if (habitat.checkHabitatType(this.getSpecies())) {
      if (habitat.checkAnimal(this.name)) {
        checkAdd = true;
      } else {
        if (this.animalIndicators.isCoLive()) {
          checkAdd = habitat.checkCoLive();
        }
      }
    }
    return checkAdd;
  }

  @Override
  public String getSpecies() {
    // Method to be overridden by child classes.
    return null;
  }

  @Override
  public int getAnimalSize() {
    int size = 0;
    if (this.animalCharacteristics.getAnimalSize().equals(AnimalSize.LARGE)) {
      size = 10;
    } else if (this.animalCharacteristics.getAnimalSize().equals(AnimalSize.MEDIUM)) {
      size = 5;
    } else if (this.animalCharacteristics.getAnimalSize().equals(AnimalSize.SMALL)) {
      size = 1;
    }
    return size;
  }

  /**
   * Method used to get a string with the name of the animal, description of the
   * animal, size of the animal, if it is poisonous, if it is endangered, if it is
   * extinct and if it can live with other species of animals.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Species name: ").append(this.name).append(", ");
    sb.append("Description: ").append(animalCharacteristics.getDescription()).append(", ");
    sb.append("Size: ").append(animalCharacteristics.getAnimalSize().name()).append(", ");
    sb.append("Poisonous: ").append(animalIndicators.isPoisonous()).append(", ");
    sb.append("Endangered: ").append(animalIndicators.isEndangered()).append(", ");
    sb.append("Extinct: ").append(animalIndicators.isExtinct()).append(", ");
    sb.append("Can live with other species: ").append(animalIndicators.isCoLive());
    return sb.toString();
  }

  @Override
  public String getAnimalName() {
    return this.name;
  }
}
