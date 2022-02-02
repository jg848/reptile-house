package reptilehouse;

/**
 * Characteristics interface which represents the defining characteristics of a
 * species which are description of the animal and size of the animal.
 * 
 * @author Jaswin Gumpella
 *
 */
public interface Characteristics {

  /**
   * Method used to get the description of the animal species.
   * 
   * @return the description which is the description of an animal.
   */
  public String getDescription();

  /**
   * Method used to get the size of the animal.
   * 
   * @return the animalSize which is the size of an animal.
   */
  public AnimalSize getAnimalSize();
}
