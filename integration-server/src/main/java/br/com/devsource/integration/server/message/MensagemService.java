package br.com.devsource.integration.server.message;

import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.devsource.integration.core.Parametro;
import br.com.devsource.integration.server.cliente.Cliente;
import br.com.devsource.integration.server.usuario.Permissao;
import br.com.devsource.integration.server.usuario.Usuario;
import br.com.devsource.integration.server.usuario.UsuarioUtils;

/**
 * @author Guilherme Pacheco
 */
public class MensagemService {

  private final MensagemRepository mensagemRepository;

  private static final Logger LOGGER = LoggerFactory.getLogger(MensagemService.class);

  public MensagemService(MensagemRepository mensagemRepository) {
    this.mensagemRepository = mensagemRepository;
  }

  public void criarMensagem(Usuario usuario, Cliente cliente, Map<Parametro, Object> values) {
    Permissao permissao = Permissao.CRIAR_MENSAGEM;
    UsuarioUtils.permite(usuario, permissao);
    Mensagem mensagem = new Mensagem(UUID.randomUUID(), cliente, values);
    mensagemRepository.salvar(mensagem);
    LOGGER.info("Usuário: {}, criou mensagem: {}", usuario, mensagem);
  }

}
