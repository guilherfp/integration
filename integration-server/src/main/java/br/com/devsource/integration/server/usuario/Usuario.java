package br.com.devsource.integration.server.usuario;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.Validate;

/**
 * @author Guilherme Pacheco
 */
public class Usuario {

  private long id;
  private String login;
  private String senha;
  private Set<Permissao> permissoes = new HashSet<>();

  Usuario() {
    super();
  }

  public Usuario(String login, String senha) {
    Validate.notBlank(login, "Login inválido");
    Validate.notBlank(senha, "Senha inválida");
    this.login = login;
    this.senha = senha;
  }

  public long getId() {
    return id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public Set<Permissao> getPermissoes() {
    return Collections.unmodifiableSet(permissoes);
  }

  public boolean isPossuiPermissao(Permissao permissao) {
    return permissoes.contains(permissao);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (login == null ? 0 : login.hashCode());
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
    Usuario other = (Usuario) obj;
    if (login == null) {
      if (other.login != null) {
        return false;
      }
    } else if (!login.equals(other.login)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return String.format("Usuario = id: %s, login: %s", id, login);
  }

}
