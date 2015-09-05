package br.com.devsource.integration.core;

import java.util.Map;

import org.apache.commons.lang3.Validate;

import com.google.gson.Gson;

/**
 * @author Guilherme Pacheco
 */
public class ProtocolParametersBuilder {

  private static final Gson GSON = new Gson();

  private ProtocolParametersBuilder() {
    super();
  }

  public static String build(Map<String, Object> parameters) {
    Validate.notNull(parameters, "Parâmetro(s) do protocolo não pode ser vazio");
    return GSON.toJson(parameters);
  }
}
