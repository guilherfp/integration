package br.com.devsource.integration.core;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author Guilherme Pacheco
 */
public class RecallValuesTest {

  @Test
  public void testBuild() throws Exception {
    Map<String, Object> map = new HashMap<>();
    map.put("id", 123);
    map.put("message", "TEST");
    assertEquals("{\"id\":123,\"message\":\"TEST\"}", RecallValues.build(map));
  }

  @Test
  public void testBuild_OneParameter() throws Exception {
    Map<String, Object> map = new HashMap<>();
    map.put("id", 123);
    assertEquals("{\"id\":123}", RecallValues.build(map));
  }

  @Test(expected = NullPointerException.class)
  public void testBuild_NullParameters() throws Exception {
    RecallValues.build(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBuild_EmptyParameters() throws Exception {
    RecallValues.build(new HashMap<>());
  }

}
