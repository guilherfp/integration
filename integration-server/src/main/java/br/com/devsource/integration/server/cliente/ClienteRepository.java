package br.com.devsource.integration.server.cliente;

import java.util.List;

/**
 * @author Guilherme Pacheco
 */
public interface ClienteRepository {

  Cliente comId(String id);

  List<Cliente> todos();

}
