package br.com.devsource.integration.server.usuario;

/**
 * @author Guilherme Pacheco
 */
public enum Permissao {

  CANCELAR_MENSAGEM("Cancelar mensagem"),
  CRIAR_MENSAGEM("Criar mensagem");

  private String nome;

  private Permissao(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }
  @Override
  public String toString() {
    return nome;
  }

}
