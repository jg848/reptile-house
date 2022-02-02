package reptilehouse;

/**
 * Indicators interface which represents the indicators of an animal. Indicates
 * if an animal is poisonous or not, endangered or not, extinct or not and can
 * live with other species of animal or not.
 * 
 * @author Jaswin Gumpella
 *
 */
public interface Indicators {
  /**
   * Method used to check if an animal is poisonous.
   * 
   * @return the poisonous which represents if an animal is poisonous or not.
   */
  public boolean isPoisonous();

  /**
   * Method used to check if an animal is endangered.
   * 
   * @return the endangered which represents if an animal is endangered or not.
   */
  public boolean isEndangered();

  /**
   * Method used to check if an animal is extinct.
   * 
   * @return the extinct which represents if an animal is extinct or not.
   */
  public boolean isExtinct();

  /**
   * Method used to check if an animal can live with other species of animals.
   * 
   * @return the coLive which represents if an animal can live with other species
   *         of animals or not.
   */
  public boolean isCoLive();

}
