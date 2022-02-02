package reptilehouse;

/**
 * Class which represents a Reptile species type. Extends the AnimalImpl class
 * containing the common aspects of a species type of an animal.
 * 
 * @author Jaswin Gumpella
 *
 */
public class Reptile extends AnimalImpl {

  /**
   * Constructor for the Reptile class which calls the parent AnimalImpl abstract
   * class containing the common functionalities of a species type of an animal.
   * 
   * @param animalName      which represents the name of the animal.
   * @param characteristics which represents the defining characteristics of an
   *                        animal like description and size.
   * @param minTemp         which represents the minimum temperature the animal
   *                        can live in.
   * @param maxTemp         which represents the maximum temperature the animal
   *                        can live in.
   * @param naturalFeature  which represents the preferred natural feature of an
   *                        animal.
   * @param indicators      which represent the indicators of an animal like
   *                        poisonous or not, endangered or not, extinct or not
   *                        and can live with other species or not.
   */
  public Reptile(String animalName, Characteristics characteristics, int minTemp, int maxTemp,
      NaturalFeatures naturalFeature, Indicators indicators) {
    super(animalName, characteristics, minTemp, maxTemp, naturalFeature, indicators);
  }

  @Override
  public String getSpecies() {
    return "REPTILE";
  }

  @Override
  public String toString() {
    return super.toString();
  }

}
