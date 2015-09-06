package br.com.devsource.integration.server.cliente;

import org.apache.commons.lang3.Validate;

/**
 * @author Guilherme Pacheco
 */
public class ClienteImpl implements Cliente, Comparable<Cliente> {

  private String id;
  private String nome;

  ClienteImpl() {
    super();
  }

  public ClienteImpl(String id, String nome) {
    Validate.notBlank(id, "ID Cliente inválido");
    Validate.notBlank(nome, "Nome cliente inválido");
    this.id = id;
    this.nome = nome;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public String getNome() {
    return nome;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (id == null ? 0 : id.hashCode());
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
    ClienteImpl other = (ClienteImpl) obj;
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    return true;
  }

  @Override
  public int compareTo(Cliente o) {
    return nome.compareTo(o.getNome());
  }

  @Override
  public String toString() {
    return "Cliente = id: " + id + ", nome: " + nome;
  }

}
