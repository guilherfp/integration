package br.com.devsource.integration.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
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

  public static String toString(Map<Constants, Object> values) {
    validate(values);
    Map<String, Object> result = new HashMap<>(values.size());
    values.entrySet().forEach(e -> result.put(e.getKey().getKey(), e.getValue()));
    return GSON.toJson(result);
  }

  @SuppressWarnings("unchecked")
  public static Map<Constants, Object> fromString(String value) {
    Map<String, Object> map = GSON.fromJson(value, Map.class);
    Map<Constants, Object> result = new HashMap<>(map.size());
    for (Entry<String, Object> entry : map.entrySet()) {
      result.put(Constants.valueOfKey(entry.getKey()), entry.getValue());
    }
    return result;
  }

  public static void validate(Map<Constants, Object> values) {
    Validate.notEmpty(values, "Parâmetro(s) do protocolo não pode ser vazio");
  }
}
