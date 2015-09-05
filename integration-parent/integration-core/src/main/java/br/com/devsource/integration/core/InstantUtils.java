package br.com.devsource.integration.core;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * @author Guilherme Pacheco
 */
public final class InstantUtils {

  private InstantUtils() {
    super();
  }

  public static LocalDateTime fromLong(long time) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(time);
    calendar.setTimeZone(TimeZone.getDefault());
    return LocalDateTime.ofInstant(calendar.toInstant(), ZoneId.of("GMT"));
  }

  public static long toLong(ChronoLocalDateTime<?> time) {
    return Date.from(time.toInstant(ZoneOffset.UTC)).getTime();
  }

}
