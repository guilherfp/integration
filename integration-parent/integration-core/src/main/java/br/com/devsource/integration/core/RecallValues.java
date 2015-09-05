package br.com.devsource.integration.core;

import java.util.Map;

import org.apache.commons.lang3.Validate;

import com.google.gson.Gson;

/**
 * @author Guilherme Pacheco
 */
public class RecallValues {

  private static final Gson GSON = new Gson();

  private RecallValues() {
    super();
  }

  public static String build(Map<String, Object> values) {
    validate(values);
    return GSON.toJson(values);
  }

  public static void validate(Map<String, Object> values) {
    Validate.notNull(values, "Parâmetro(s) do protocolo não pode ser vazio");
  }
}
