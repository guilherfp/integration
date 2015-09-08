package br.com.devsource.integration.server.application;

import org.glassfish.grizzly.websockets.WebSocket;
import org.glassfish.grizzly.websockets.WebSocketApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Guilherme Pacheco
 */
public class RecallApplication extends WebSocketApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(RecallApplication.class);

  @Override
  public void onConnect(WebSocket socket) {
    LOGGER.info("Connected: {}", socket.toString());
  }

  @Override
  public void onPing(WebSocket socket, byte[] bytes) {
    LOGGER.info("PING...");
  }

  @Override
  public void onPong(WebSocket socket, byte[] bytes) {
    LOGGER.info("PONG...");
  }

  @Override
  public void onMessage(WebSocket socket, String text) {
    LOGGER.info("Mensagem recebida: {}", text);
  }

}
