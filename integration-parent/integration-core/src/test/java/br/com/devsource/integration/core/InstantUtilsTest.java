package br.com.devsource.integration.core;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Guilherme Pacheco
 */
public class InstantUtilsTest {

  private LocalDateTime dateTime;
  private long longDateTime;

  @Before
  public void setUp() throws Exception {
    dateTime = LocalDateTime.of(2015, 9, 5, 17, 20);
    longDateTime = 1441473600000L;
  }

  @Test
  public void testFromLong() throws Exception {
    assertEquals(dateTime, InstantUtils.fromLong(longDateTime));
  }

  @Test
  public void testToLong() throws Exception {
    assertEquals(longDateTime, InstantUtils.toLong(dateTime));
  }

}
