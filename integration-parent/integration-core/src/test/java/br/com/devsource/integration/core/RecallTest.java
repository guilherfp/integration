package br.com.devsource.integration.core;

import static java.util.Collections.emptyMap;
import static java.util.Collections.singletonMap;
import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Guilherme Pacheco
 */
public class RecallTest {

  private LocalDateTime instante;

  @Before
  public void setUp() throws Exception {
    instante = LocalDateTime.of(2015, 9, 5, 17, 20);
  }

  @Test
  public void testToString() throws Exception {
    Map<String, Object> map = singletonMap(Constants.MESSAGE, "TESTE");
    Recall recall = new Recall("32", InstantUtils.toLong(instante), map);
    assertEquals("32[{\"m\":\"TESTE\"}]1441473600000", recall.toString());
  }

  @Test
  public void testToString_ComAcao() throws Exception {
    Recall recall = new Recall("32", InstantUtils.toLong(instante), "ping");
    assertEquals("32[ping]1441473600000", recall.toString());
  }

  @Test
  public void testIsAction() throws Exception {
    Recall recall = new Recall("32", InstantUtils.toLong(instante), "ping");
    assertTrue(recall.isAction());
  }

  @Test
  public void testIsAction_NullAction() throws Exception {
    String action = null;
    Recall recall = new Recall("32", InstantUtils.toLong(instante), action);
    assertFalse(recall.isAction());
  }

  @Test
  public void testIsAction_BlankAction() throws Exception {
    Recall recall = new Recall("32", InstantUtils.toLong(instante), "");
    assertFalse(recall.isAction());
  }

  @Test
  public void testIsAction_NoAction() throws Exception {
    Recall recall = new Recall("32", InstantUtils.toLong(instante), emptyMap());
    assertFalse(recall.isAction());
  }

}
