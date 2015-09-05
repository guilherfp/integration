package br.com.devsource.integration.core;

/**
 * @author Guilherme Pacheco
 */
public enum Action implements HasKey {

  PING("Ping", "ping"),
  PONG("Pong", "pong"),
  RETRY("Retry", "r");

  private String descricao;
  private String key;

  private Action(String descricao, String key) {
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

  public static Action valueOfKey(String key) {
    return HasKey.valueOfKey(key, values());
  }

  @Override
  public String toString() {
    return String.format("(%s) %s", key, descricao);
  }
}
