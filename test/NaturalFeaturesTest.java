import static org.junit.Assert.assertEquals;

import org.junit.Test;
import reptilehouse.NaturalFeatures;

/**
 * Class used to test the enumerations of Natural Features.
 * 
 * @author Jaswin Gumpella
 *
 */
public class NaturalFeaturesTest {

  /**
   * Method used to test the DESERT enum value of NaturalFeatures.
   */
  @Test
  public final void testNaturalFeatureDessert() {
    assertEquals("DESERT", NaturalFeatures.DESERT.name());
  }

  /**
   * Method used to test the FALLEN_LOGS enum value of NaturalFeatures.
   */
  @Test
  public final void testNaturalFeatureFallenLogs() {
    assertEquals("FALLEN_LOGS", NaturalFeatures.FALLEN_LOGS.name());
  }

  /**
   * Method used to test the FLOWING_WATER enum value of NaturalFeatures.
   */
  @Test
  public final void testNaturalFeatureFlowingWater() {
    assertEquals("FLOWING_WATER", NaturalFeatures.FLOWING_WATER.name());
  }

  /**
   * Method used to test the GRASS enum value of NaturalFeatures.
   */
  @Test
  public final void testNaturalFeatureGrass() {
    assertEquals("GRASS", NaturalFeatures.GRASS.name());
  }

  /**
   * Method used to test the LILY_PADS enum value of NaturalFeatures.
   */
  @Test
  public final void testNaturalFeatureLilyPads() {
    assertEquals("LILY_PADS", NaturalFeatures.LILY_PADS.name());
  }

  /**
   * Method used to test the POND enum value of NaturalFeatures.
   */
  @Test
  public final void testNaturalFeaturePond() {
    assertEquals("POND", NaturalFeatures.POND.name());
  }

  /**
   * Method used to test the ROCKS enum value of NaturalFeatures.
   */
  @Test
  public final void testNaturalFeatureRocks() {
    assertEquals("ROCKS", NaturalFeatures.ROCKS.name());
  }

  /**
   * Method used to test the SALT_WATER enum value of NaturalFeatures.
   */
  @Test
  public final void testNaturalFeatureSaltWater() {
    assertEquals("SALT_WATER", NaturalFeatures.SALT_WATER.name());
  }

  /**
   * Method used to test the SANDY_BEACH enum value of NaturalFeatures.
   */
  @Test
  public final void testNaturalFeatureSandyBeach() {
    assertEquals("SANDY_BEACH", NaturalFeatures.SANDY_BEACH.name());
  }

  /**
   * Method used to test the TREE_BRANCHES enum value of NaturalFeatures.
   */
  @Test
  public final void testNaturalFeatureTreeBranches() {
    assertEquals("TREE_BRANCHES", NaturalFeatures.TREE_BRANCHES.name());
  }

}
