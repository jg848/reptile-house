package reptilehouse;

import java.util.List;

/**
 * Interface which represents an entire reptile house which contains various
 * habitats inside it.
 * 
 * @author Jaswin Gumpella
 *
 */
public interface ReptileHouse {

  /**
   * Method used to create a habitat in the reptile house by taking inputs of the
   * name, size, list of natural features, location, minimum temperature and
   * maximum temperature of the habitat.
   * 
   * @param habitatName     which represents the name of the habitat.
   * @param habitatSize     which represents the size of the habitat.
   * @param naturalFeatures which represents the list of natural features of the
   *                        habitat.
   * @param location        which represents the location of the habitat.
   * @param minTemperature  which represents the minimum temperature of the
   *                        habitat.
   * @param maxTemperature  which represents the maximum temperature of the
   *                        habitat.
   * @return true if a habitat is created, false if not.
   */
  public boolean createHabitat(String habitatName, int habitatSize,
      List<NaturalFeatures> naturalFeatures, String location, int minTemperature,
      int maxTemperature);

  /**
   * Method which is used to add an animal into a habitat if all the necessary
   * conditions are met.
   * 
   * @param animalName      which represents the name of the animal.
   * @param animalSpecies   which represents the species type of the animal.
   * @param characteristics which represents the defining characteristics of an
   *                        animal like description of the animal and size of the
   *                        animal.
   * @param minTemp         which represents the preferred minimum temperature of
   *                        the animal.
   * @param maxTemp         which represents the preferred maximum temperature of
   *                        the animal.
   * @param naturalFeature  which represents the preferred natural feature of the
   *                        animal.
   * @param indicators      which represents the indicators of an animal like if
   *                        it is poisonous or not, endangered or not, extinct or
   *                        not and can live with other species of animals or not.
   * @return true if animal is added into habitat, false if not.
   */
  public boolean addAnimal(String animalName, String animalSpecies, Characteristics characteristics,
      int minTemp, int maxTemp, NaturalFeatures naturalFeature, Indicators indicators);

  /**
   * Method used to report all the natural features which are currently being used
   * in the reptile house in alphabetical order and includes the habitat(s) where
   * the natural feature is located and how much space is left in the habitat for
   * additional animals.
   * 
   * @return a string which contains the natural feature with the habitat where
   *         the natural feature is used and available space in the habitat.
   */
  public String reportNaturalFeatures();

  /**
   * Method used to look up which habitat(s) house a particular species type.
   * 
   * @param species which is the species type used to check with the habitat
   *                species type.
   * @return a string with habitat(s) that house the given species type.
   */
  public String lookUpHabitat(String species);

  /**
   * Method used to print a sign for the given habitat that lists the species that
   * it houses along with a description of the species (including their name,
   * their defining characteristics and other indicators like poisonous, extinct,
   * endangered, can live with other species) and an indicator of how many of that
   * species is housed in that habitat.
   * 
   * @param habitatName which is the name of the habitat to print the sign for.
   * @return a string which contains the name of the habitat and the description
   *         of the species living in the habitat with the frequency of the
   *         species.
   */
  public String printSignForHabitat(String habitatName);

  /**
   * Method used to list all the habitats by location and the natural features in
   * the habitat and species they house.
   * 
   * @return a string which contains a map of all the locations of the habitats
   *         with the natural features in the habitat and species they house.
   */
  public String mapAllHabitats();

  /**
   * Method used to get an index that lists all species in the Reptile House in
   * alphabetical order and their location(s).
   * 
   * @return a string which contains all the species in the Reptile House and
   *         their location(s).
   */
  public String indexOfSpecies();
}
