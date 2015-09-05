package br.com.devsource.integration.core;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import br.com.devsource.integration.core.Recall.RecallBuilder;

/**
 * @author Guilherme Pacheco
 */
public final class RecallFactory {

  public static Recall valueOf(String value) {
    RecallBuilder builder = Recall.RecallBuilder.create();
    builder.id(id(value));
    builder.time(time(value));
    String body = body(value);
    if (isMessage(body)) {
      builder.values(values(body));
    } else {
      builder.action(action(body));
    }
    return builder.build();
  }

  private static Action action(String body) {
    return Action.valueOfKey(body);
  }

  private static boolean isMessage(String body) {
    return StringUtils.containsAny(body, "{", "}");
  }

  private static Map<Parametro, Object> values(String body) {
    return RecallValues.fromString(body);
  }

  private static String body(String value) {
    return StringUtils.substringBetween(value, "[", "]");
  }

  private static Long time(String value) {
    return Long.valueOf(StringUtils.substringAfterLast(value, "]"));
  }

  private static String id(String value) {
    return StringUtils.substringBefore(value, "[");
  }

}
