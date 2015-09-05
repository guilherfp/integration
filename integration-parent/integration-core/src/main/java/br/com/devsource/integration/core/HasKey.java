package br.com.devsource.integration.core;

/**
 * @author Guilherme Pacheco
 */
public interface HasKey {

  String getKey();

  public static <T extends HasKey> T valueOfKey(String key, T[] values) {
    for (T hasKey : values) {
      if (hasKey.getKey().equalsIgnoreCase(key)) {
        return hasKey;
      }
    }
    throw new IllegalArgumentException("Não foi encontrado um valor correspondente para: " + key);
  }

}
