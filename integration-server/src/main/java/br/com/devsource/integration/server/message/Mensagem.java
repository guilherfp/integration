package br.com.devsource.integration.server.message;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.devsource.integration.core.Parametro;
import br.com.devsource.integration.server.ToStringBuilder;
import br.com.devsource.integration.server.cliente.Cliente;

/**
 * @author Guilherme Pacheco
 */
public class Mensagem {

  private String uuid;
  private Cliente cliente;
  private Map<Parametro, Object> values;
  private LocalDateTime criacao;
  private LocalDateTime envio;
  private LocalDateTime recebimento;
  private boolean cancelada;

  private static final Logger LOGGER = LoggerFactory.getLogger(Mensagem.class);

  Mensagem() {
    super();
  }

  Mensagem(UUID uuid, Cliente cliente, Map<Parametro, Object> values) {
    this(uuid, values);
    values.put(Parametro.CLIENT, cliente.getId());
    this.cliente = cliente;
  }

  Mensagem(UUID uuid, Map<Parametro, Object> values) {
    Validate.notEmpty(values, "Parâmetro(s) do protocolo não pode ser vazio");
    Validate.notNull(uuid, "UUID inválido");
    criacao = LocalDateTime.now();
    this.uuid = uuid.toString();
    this.values = values;
  }

  public String getUuid() {
    return uuid;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public boolean isCliente() {
    return cliente != null;
  }

  public Map<Parametro, Object> getValues() {
    return Collections.unmodifiableMap(values);
  }

  public LocalDateTime getCriacao() {
    return criacao;
  }

  public LocalDateTime getEnvio() {
    return envio;
  }

  public void enviado() {
    if (envio == null) {
      LOGGER.info("Mensagem: {} enviada", uuid);
      envio = LocalDateTime.now();
    }
  }

  public LocalDateTime getRecebimento() {
    return recebimento;
  }

  public void recebido() {
    if (recebimento == null) {
      LOGGER.info("Mensagem: {} recebida", uuid);
      recebimento = LocalDateTime.now();
    }
  }

  public boolean isCancelada() {
    return cancelada;
  }

  public void cancelar() {
    cancelada = true;
  }

  @Override
  public String toString() {
    ToStringBuilder builder = new ToStringBuilder("Mensagem = ");
    builder.append("UUID", uuid);
    builder.append(cliente);
    builder.append("Criação", criacao);
    builder.append("Envio", envio, "Não enviado");
    builder.append("Recebimento", recebimento, "Não recebido");
    builder.isTrue(cancelada, "cancelada");
    return builder.toString();
  }

}
