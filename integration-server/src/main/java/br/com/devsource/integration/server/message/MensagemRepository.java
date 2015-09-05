package br.com.devsource.integration.server.message;

import java.util.Collection;
import java.util.List;

import br.com.devsource.integration.core.Parametro;
import br.com.devsource.integration.server.cliente.Cliente;

/**
 * @author Guilherme Pacheco
 */
public interface MensagemRepository {

  Mensagem comUUID(String uuid);

  List<Mensagem> todas();

  List<Mensagem> enviadas();

  List<Mensagem> recebidas();

  List<Mensagem> doCliente(Cliente cliente);

  List<Mensagem> comParametros(Collection<Parametro> parametro);

  void salvar(Mensagem mensagem);

}
