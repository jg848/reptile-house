package reptilehouse;

import java.util.List;
import java.util.Map;

/**
 * Interface for Habitat which represents a single habitat inside a reptile
 * house.
 * 
 * @author Jaswin Gumpella
 *
 */
public interface Habitat {

  /**
   * Method used to check if the given natural feature is present in the list of
   * natural features of the habitat.
   * 
   * @param animalNaturalFeature which is the preferred natural feature of the
   *                             animal to be checked if it is present in the list
   *                             of natural features of the habitat.
   * @return true if the given natural feature is present in the list of natural
   *         features of the habitat, false if not.
   */
  public boolean checkNaturalFeatures(NaturalFeatures animalNaturalFeature);

  /**
   * Method used to add a given natural feature to the list of natural features of
   * the habitat.
   * 
   * @param animalNaturalFeature which is the natural feature of the animal not
   *                             present in the list of natural features of the
   *                             habitat.
   * @return
   */
  public boolean addNaturalFeature(NaturalFeatures animalNaturalFeature);

  /**
   * Method used to check if the habitat is empty i.e, not inhabited by any animal
   * species.
   * 
   * @return true if habitat is empty, false if not.
   */
  public boolean checkIfEmpty();

  /**
   * Method used to check if the given temperature range of an animal is
   * overlapping with the temperature range of the habitat.
   * 
   * @param minimumTemperature which is the preferred minimum temperature of an
   *                           animal.
   * @param maximumTemperature which is the preferred maximum temperature of an
   *                           animal.
   * @return
   */
  public boolean checkTemperatureRange(int minimumTemperature, int maximumTemperature);

  /**
   * Method used to check if there is space available in the habitat to add an
   * animal of given size.
   * 
   * @param animalSize which is the size of the animal.
   * @return true if space is available to add the animal, false if not.
   */
  public boolean checkSizeAvailable(AnimalSize animalSize);

  /**
   * Method used to check the species type of the habitat with the given species
   * type.
   * 
   * @param species which is the species type of the animal given.
   * @return true if the given species type is same as the habitat species type,
   *         false if not.
   */
  public boolean checkHabitatType(String species);

  /**
   * Method used to check if the animal species inside the habitat can live with
   * other species.
   * 
   * @return true if all animal species inside the habitat can live with other
   *         species, false if not.
   */
  public boolean checkCoLive();

  /**
   * Method used to check if there is only one animal species living in the
   * habitat and if it is the same as the given animal.
   * 
   * @param animal which is the animal species to be checked with the animal
   *               species inside the habitat.
   * @return true if the given animal species and the animal species inside the
   *         habitat are same, false if there are more than one animal species or
   *         if the given animal species if different from the animal species
   *         living in the habitat.
   */
  public boolean checkAnimal(String animal);

  /**
   * Method used to add the given animal into the list of animals living in the
   * habitat.
   * 
   * @param animal which is the animal to be added into the list of animals living
   *               in the habitat.
   */
  public boolean addAnimal(Animal animal);

  /**
   * Method used to get the list of natural features of the habitat.
   * 
   * @return the list of natural features of the habitat.
   */
  public List<NaturalFeatures> getNaturalFeatures();

  /**
   * Method used to check if the given natural feature is present in the habitat
   * and return the maximum size available in the habitat if present.
   * 
   * @param naturalFeature which is the natural feature to be checked with the
   *                       list of natural features of the habitat.
   * @return a string which contains the maximum available space in the habitat.
   */
  public String getNaturalFeaturesSize(NaturalFeatures naturalFeature);

  /**
   * Method used to get the name of the habitat.
   * 
   * @return the name of the habitat.
   */
  public String getHabitatName();

  /**
   * Method used to get the location of the habitat.
   * 
   * @return the location of the habitat.
   */
  public String getHabitatLocation();

  /**
   * Method used to get the habitat name, list of natural features of the habitat
   * and name of the species in the habitat.
   * 
   * @return
   */
  public String getHabitatMapDetails();

  /**
   * Method used to get a map with the name of the species and location of the
   * habitat.
   * 
   * @return a map which contains a key, value pair of name of the species and
   *         location of the habitat.
   */
  public Map<String, String> getSpeciesMap();

}
