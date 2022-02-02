package reptilehouse;

/**
 * Implementation class for Indicators interface which represents the indicators
 * of an animal. Indicates if an animal is poisonous or not, endangered or not,
 * extinct or not and can live with other species of animal or not.
 * 
 * @author Jaswin Gumpella
 *
 */
public class IndicatorsImpl implements Indicators {

  private boolean poisonous;
  private boolean endangered;
  private boolean extinct;
  private boolean coLive;

  /**
   * Constructor for the Indicators class which is used to set the indicators of
   * an animal.
   * 
   * @param isPoisonous  which represents if an animal is poisonous or not.
   * @param isEndangered which represents if an animal is endangered or not.
   * @param isExtinct    which represents if an animal is extinct or not.
   * @param canCoLive    which represents if an animal can live with other species
   *                     of animals or not.
   */
  public IndicatorsImpl(boolean isPoisonous, boolean isEndangered, boolean isExtinct,
      boolean canCoLive) {
    this.poisonous = isPoisonous;
    this.endangered = isEndangered;
    this.extinct = isExtinct;
    this.coLive = canCoLive;
  }

  @Override
  public boolean isPoisonous() {
    return poisonous;
  }

  @Override
  public boolean isEndangered() {
    return endangered;
  }

  @Override
  public boolean isExtinct() {
    return extinct;
  }

  @Override
  public boolean isCoLive() {
    return coLive;
  }

}
