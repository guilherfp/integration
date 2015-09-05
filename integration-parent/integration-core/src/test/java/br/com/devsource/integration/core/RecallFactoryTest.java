package br.com.devsource.integration.core;

import static java.util.Collections.emptyMap;
import static java.util.Collections.singletonMap;
import static org.junit.Assert.*;

import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Guilherme Pacheco
 */
public class RecallFactoryTest {

  private LocalDateTime dateTime;

  @Before
  public void setUp() throws Exception {
    dateTime = LocalDateTime.of(2015, 9, 5, 17, 20);
  }
  @Test
  public void testValueOf_Message() throws Exception {
    String msg = "32[{\"m\":\"TESTE\"}]1441473600000";
    Recall recall = RecallFactory.valueOf(msg);
    assertEquals("32", recall.getId());
    assertFalse(recall.isAction());
    assertEquals(singletonMap(Parametro.MESSAGE, "TESTE"), recall.getValues());
    assertEquals(dateTime, recall.getLocalDateTime());
  }
  @Test
  public void testValueOf_Action() throws Exception {
    String msg = "32[ping]1441473600000";
    Recall recall = RecallFactory.valueOf(msg);
    assertEquals("32", recall.getId());
    assertTrue(recall.isAction());
    assertEquals(Action.PING, recall.getAction());
    assertEquals(emptyMap(), recall.getValues());
    assertEquals(dateTime, recall.getLocalDateTime());
  }

}
