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

  private LocalDateTime dateTime;

  @Before
  public void setUp() throws Exception {
    dateTime = LocalDateTime.of(2015, 9, 5, 17, 20);
  }

  @Test(expected = NullPointerException.class)
  public void testRecall_NullId() throws Exception {
    new Recall(null, 234324L, Action.PING);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRecall_BlankId() throws Exception {
    new Recall(" ", 234324L, Action.PING);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRecall_NegativeTime() throws Exception {
    new Recall("123", -234324L, Action.PING);
  }

  @Test
  public void testToString() throws Exception {
    Map<Constants, Object> map = singletonMap(Constants.MESSAGE, "TESTE");
    Recall recall = new Recall("32", InstantUtils.toLong(dateTime), map);
    assertEquals("32[{\"m\":\"TESTE\"}]1441473600000", recall.toString());
  }

  @Test
  public void testToString_ComAcao() throws Exception {
    Recall recall = new Recall("32", InstantUtils.toLong(dateTime), Action.PING);
    assertEquals("32[ping]1441473600000", recall.toString());
  }

  @Test
  public void testIsAction() throws Exception {
    Recall recall = new Recall("32", InstantUtils.toLong(dateTime), Action.PING);
    assertEquals(emptyMap(), recall.getValues());
    assertTrue(recall.isAction());
  }

  @Test(expected = NullPointerException.class)
  public void testIsAction_NullAction() throws Exception {
    Action action = null;
    new Recall("32", InstantUtils.toLong(dateTime), action);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIsAction_EmptyMessage() throws Exception {
    Recall recall = new Recall("32", InstantUtils.toLong(dateTime), emptyMap());
    assertFalse(recall.isAction());
  }

  @Test
  public void testEquals() throws Exception {
    Recall recall = new Recall("32", InstantUtils.toLong(dateTime), Action.PING);
    assertEquals(recall, new Recall("32", InstantUtils.toLong(dateTime), Action.PING));
    assertNotEquals(recall, new Object());
    assertNotEquals(recall, null);
    assertEquals(recall, recall);
  }

  @Test
  public void testHashCode() throws Exception {
    Recall recall = new Recall("32", InstantUtils.toLong(dateTime), Action.PING);
    assertEquals(recall, new Recall("32", InstantUtils.toLong(dateTime), Action.PING));
    assertNotEquals(recall.hashCode(), new Object().hashCode());
    assertEquals(recall.hashCode(), recall.hashCode());
  }

}
