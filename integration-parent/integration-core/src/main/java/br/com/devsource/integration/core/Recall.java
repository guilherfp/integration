package br.com.devsource.integration.core;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Guilherme Pacheco
 */
public class Recall {

  private String id;
  private long time;
  private String action;
  private Map<String, Object> values = new HashMap<>();

  Recall() {
    super();
  }

  private Recall(String id, long time) {
    this.time = time;
    this.id = id;
  }

  public Recall(String id, long time, String action) {
    this(id, time);
    this.action = action;
  }

  public Recall(String id, long time, Map<String, Object> values) {
    this(id, time);
    this.values = values;
  }

  public String getId() {
    return id;
  }

  public String getMessage() {
    return values.get(Constants.MESSAGE).toString();
  }

  public Instant getInstant() {
    return InstantUtils.fromLong(getTime());
  }

  private long getTime() {
    return time;
  }

  public boolean isAction() {
    return StringUtils.isNotBlank(action);
  }

  public String getAction() {
    return action;
  }

  @Override
  public String toString() {
    return String.format("%s[%s]%s", id, getBody(), time);
  }

  private String getBody() {
    if (isAction()) {
      return StringUtils.defaultString(action);
    } else {
      return ProtocolParametersBuilder.build(values);
    }
  }

}
