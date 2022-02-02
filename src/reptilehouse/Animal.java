package reptilehouse;

/**
 * Animal interface which represents a single animal species.
 * 
 * @author Jaswin Gumpella
 *
 */
public interface Animal {

  /**
   * Method used to check if an animal species can be added into a given habitat.
   * Checks the temperature range, natural feature and available size and returns
   * if it is possible to add into the given habitat.
   * 
   * @param habitat which is a habitat from the reptile house to be checked if an
   *                animal can be added.
   * @return true if the animal can be added into the given habitat, false if it
   *         cannot be added into the given habitat.
   */
  public boolean checkAddAnimal(Habitat habitat);

  /**
   * Method used to get the indicator of an animal if it can live with other
   * species or not.
   * 
   * @return true if animal can live with other animal species, false if animal
   *         cannot live with other species.
   */
  public boolean isCoLive();

  /**
   * Method used to get the species type of the animal.
   * 
   * @return the Species type of an animal.
   */
  public String getSpecies();

  /**
   * Method used to get the size characteristic of an animal.
   * 
   * @return an integer value which is 10 for Large sized animal, 5 for Medium
   *         sized animal and 1 for Small sized animal.
   */
  public int getAnimalSize();

  /**
   * Method used to get the name of the animal species.
   * 
   * @return the name of the animal species.
   */
  public String getAnimalName();

}
