package br.com.devsource.integration.core;

/**
 * @author Guilherme Pacheco
 */
public enum Constants implements HasKey {

  MESSAGE("Mensagem", "m"),
  CLIENT("Código do cliente", "c"),
  VERSAO_ERP("Versão do ERP", "v");

  private String descricao;
  private String key;

  private Constants(String descricao, String key) {
    this.descricao = descricao;
    this.key = key;
  }

  public String getDescricao() {
    return descricao;
  }

  @Override
  public String getKey() {
    return key;
  }

  public static Constants valueOfKey(String key) {
    return HasKey.valueOfKey(key, values());
  }

  @Override
  public String toString() {
    return String.format("(%s) %s", key, descricao);
  }

}
