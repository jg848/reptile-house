import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import reptilehouse.Indicators;
import reptilehouse.IndicatorsImpl;

/**
 * Test class for IndicatorsImpl class which implements the Indicators
 * interface. Used to test the indicators of an animal species like if the
 * animal is poisonous or not, endangered or not, extinct or not and can live
 * with other animal species or not.
 * 
 * @author Jaswin Gumpella
 *
 */
public class IndicatorsImplTest {

  Indicators indicators1;
  Indicators indicators2;

  /**
   * Method used to setup the required instances for the test class.
   * 
   * @throws IllegalArgumentException in case of any exception.
   */
  @Before
  public void setUp() throws IllegalArgumentException {
    indicators1 = new IndicatorsImpl(true, true, false, false);
    indicators2 = new IndicatorsImpl(false, false, true, true);
  }

  /**
   * Test method for
   * {@link reptilehouse.IndicatorsImpl#IndicatorsImpl(boolean, boolean, boolean, boolean)}.
   */
  @Test
  public final void testIndicatorsImpl() {
    indicators1 = new IndicatorsImpl(true, false, true, false);
    assertEquals(IndicatorsImpl.class, indicators1.getClass());
  }

  /**
   * Test method for {@link reptilehouse.IndicatorsImpl#isPoisonous()}.
   */
  @Test
  public final void testIsPoisonousTrue() {
    assertEquals(true, indicators1.isPoisonous());
  }

  /**
   * Test method for {@link reptilehouse.IndicatorsImpl#isPoisonous()}.
   */
  @Test
  public final void testIsPoisonousFalse() {
    assertEquals(false, indicators2.isPoisonous());
  }

  /**
   * Test method for {@link reptilehouse.IndicatorsImpl#isEndangered()}.
   */
  @Test
  public final void testIsEndangeredTrue() {
    assertEquals(true, indicators1.isEndangered());
  }

  /**
   * Test method for {@link reptilehouse.IndicatorsImpl#isEndangered()}.
   */
  @Test
  public final void testIsEndangeredFalse() {
    assertEquals(false, indicators2.isEndangered());
  }

  /**
   * Test method for {@link reptilehouse.IndicatorsImpl#isExtinct()}.
   */
  @Test
  public final void testIsExtinctTrue() {
    assertEquals(true, indicators2.isExtinct());
  }

  /**
   * Test method for {@link reptilehouse.IndicatorsImpl#isExtinct()}.
   */
  @Test
  public final void testIsExtinctFalse() {
    assertEquals(false, indicators1.isExtinct());
  }

  /**
   * Test method for {@link reptilehouse.IndicatorsImpl#isCoLive()}.
   */
  @Test
  public final void testIsCoLiveTrue() {
    assertEquals(true, indicators2.isCoLive());
  }

  /**
   * Test method for {@link reptilehouse.IndicatorsImpl#isCoLive()}.
   */
  @Test
  public final void testIsCoLiveFalse() {
    assertEquals(false, indicators1.isCoLive());
  }

}
