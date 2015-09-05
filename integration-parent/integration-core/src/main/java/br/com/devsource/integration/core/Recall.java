package br.com.devsource.integration.core;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;

/**
 * @author Guilherme Pacheco
 */
public final class Recall {

  private String id;
  private long time;
  private Action action;
  private Map<Parametro, Object> values;

  Recall() {
    super();
  }

  private Recall(String id, long time) {
    Validate.notBlank(id, "ID Recall inválido");
    Validate.isTrue(time > 0, "Time Recall inválido");
    this.id = id;
    this.time = time;
  }

  public Recall(String id, long time, Action action) {
    this(id, time);
    Validate.notNull(action, "Ação Recall inválida");
    this.action = action;
  }

  public Recall(String id, long time, Map<Parametro, Object> values) {
    this(id, time);
    RecallValues.validate(values);
    this.values = values;
  }

  private Recall(RecallBuilder builder) {
    this(builder.id, builder.time);
    action = builder.action;
    values = builder.values;
  }

  public String getId() {
    return id;
  }

  public LocalDateTime getLocalDateTime() {
    return InstantUtils.fromLong(getTime());
  }

  private long getTime() {
    return time;
  }

  public boolean isAction() {
    return action != null;
  }

  public Action getAction() {
    return action;
  }

  public Map<Parametro, Object> getValues() {
    return Collections.unmodifiableMap(safeValues());
  }

  private Map<Parametro, Object> safeValues() {
    return ObjectUtils.defaultIfNull(values, new HashMap<>());
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (id == null ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Recall other = (Recall) obj;
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return String.format("%s[%s]%s", id, getBody(), time);
  }

  private String getBody() {
    if (isAction()) {
      return action.getKey();
    } else {
      return RecallValues.toString(safeValues());
    }
  }

  public static class RecallBuilder {
    private String id;
    private long time;
    private Action action;
    private Map<Parametro, Object> values = new HashMap<>();

    private RecallBuilder() {
      super();
    }

    public Recall.RecallBuilder id(String id) {
      this.id = id;
      return this;
    }

    public Recall.RecallBuilder time(long time) {
      this.time = time;
      return this;
    }

    public Recall.RecallBuilder action(Action action) {
      this.action = action;
      return this;
    }

    public Recall.RecallBuilder values(Map<Parametro, Object> values) {
      this.values = values;
      return this;
    }

    public static RecallBuilder create() {
      return new RecallBuilder();
    }

    public Recall build() {
      return new Recall(this);
    }

  }

}
