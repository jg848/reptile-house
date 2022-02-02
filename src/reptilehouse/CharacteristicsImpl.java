package reptilehouse;

/**
 * Implementation class of Characteristics interface which represents the
 * defining characteristics of a species which are description of the animal and
 * size of the animal.
 * 
 * @author Jaswin Gumpella
 *
 */
public class CharacteristicsImpl implements Characteristics {

  private String description;
  private AnimalSize animalSize;

  /**
   * Constructor for the Characteristics class which is used to set the values of
   * description and size of an animal which are the defining characteristics of
   * an animal species.
   * 
   * @param desc which is the description of an animal.
   * @param size which is the size of an animal.
   */
  public CharacteristicsImpl(String desc, AnimalSize size) {
    if (null != desc && !desc.isEmpty()) {
      this.description = desc;
    } else {
      throw new IllegalArgumentException("Description of an animal cannot be empty.");
    }
    if (null != size && (size.equals(AnimalSize.LARGE) || size.equals(AnimalSize.MEDIUM)
        || size.equals(AnimalSize.SMALL))) {
      this.animalSize = size;
    } else {
      throw new IllegalArgumentException(
          "Invalid animal size input. Please insert a value of AnimalSize {SMALL, MEDIUM, LARGE}");
    }
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public AnimalSize getAnimalSize() {
    return animalSize;
  }
}
