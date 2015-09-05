package br.com.devsource.integration.core;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

/**
 * @author Guilherme Pacheco
 */
public class RecallValuesTest {

  @Test
  public void testToString() throws Exception {
    Map<Constants, Object> map = new TreeMap<>();
    map.put(Constants.CLIENT, 123);
    map.put(Constants.MESSAGE, "TEST");
    assertEquals("{\"m\":\"TEST\",\"c\":123}", RecallValues.toString(map));
  }

  @Test
  public void testToString_OneParameter() throws Exception {
    Map<Constants, Object> map = new TreeMap<>();
    map.put(Constants.CLIENT, 123);
    assertEquals("{\"c\":123}", RecallValues.toString(map));
  }

  @Test(expected = NullPointerException.class)
  public void testToString_NullParameters() throws Exception {
    RecallValues.toString(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testToString_EmptyParameters() throws Exception {
    RecallValues.toString(new HashMap<>());
  }

  @Test
  public void testFromString() throws Exception {
    Map<Constants, Object> map = RecallValues.fromString("{\"m\":\"TEST\",\"c\":123}");
    assertNotNull(map);
    assertEquals(2, map.size());
    assertEquals("TEST", map.get(Constants.MESSAGE));
    assertEquals(123.0, map.get(Constants.CLIENT));
  }

}
