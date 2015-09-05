package br.com.devsource.integration.server;

import org.apache.commons.lang3.ObjectUtils;

/**
 * @author Guilherme Pacheco
 */
public final class ToStringBuilder {

  private StringBuilder builder;
  private boolean added;

  public ToStringBuilder() {
    builder = new StringBuilder();
  }

  public ToStringBuilder(CharSequence seq) {
    builder = new StringBuilder(seq);
  }

  public void append(String field, Object value) {
    if (added) {
      builder.append(", ");
    }
    builder.append(field);
    builder.append(": ");
    builder.append(value);
    added = true;
  }

  public void append(String field, Object value, Object defaultValue) {
    append(field, ObjectUtils.defaultIfNull(value, defaultValue));
  }

  @Override
  public String toString() {
    return builder.toString();
  }

}
