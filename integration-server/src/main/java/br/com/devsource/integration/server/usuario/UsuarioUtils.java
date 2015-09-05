package br.com.devsource.integration.server.usuario;

import org.apache.commons.lang3.Validate;

/**
 * @author Guilherme Pacheco
 */
public final class UsuarioUtils {

  private UsuarioUtils() {
    super();
  }

  public static void permite(Usuario usuario, Permissao permissao) {
    Validate.notNull(usuario, "Usuário inválido");
    boolean permite = usuario.isPossuiPermissao(permissao);
    Validate.isTrue(permite, "Usuário %s não possui permissão: %s", usuario, permissao);
  }

}
