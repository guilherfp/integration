package br.com.devsource.integration.core;

import java.sql.Date;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Calendar;

/**
 * @author Guilherme Pacheco
 */
public final class InstantUtils {

  private InstantUtils() {
    super();
  }

  public static Instant fromLong(long time) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(time);
    return calendar.toInstant();
  }

  public static long toLong(ChronoLocalDateTime<?> time) {
    return Date.from(time.toInstant(ZoneOffset.UTC)).getTime();
  }

}
