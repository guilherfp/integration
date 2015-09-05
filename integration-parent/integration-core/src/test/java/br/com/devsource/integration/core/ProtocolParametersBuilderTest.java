package br.com.devsource.integration.core;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author Guilherme Pacheco
 */
public class ProtocolParametersBuilderTest {

  @Test
  public void testBuild() throws Exception {
    Map<String, Object> map = new HashMap<>();
    map.put("id", 123);
    map.put("message", "TEST");
    assertEquals("{\"id\":123,\"message\":\"TEST\"}", ProtocolParametersBuilder.build(map));
  }

  @Test
  public void testBuild_OneParameter() throws Exception {
    Map<String, Object> map = new HashMap<>();
    map.put("id", 123);
    assertEquals("{\"id\":123}", ProtocolParametersBuilder.build(map));
  }

  @Test(expected = NullPointerException.class)
  public void testBuild_NullParameters() throws Exception {
    ProtocolParametersBuilder.build(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBuild_EmptyParameters() throws Exception {
    ProtocolParametersBuilder.build(new HashMap<>());
  }

}
