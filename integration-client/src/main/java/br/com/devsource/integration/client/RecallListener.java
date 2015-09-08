package br.com.devsource.integration.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ning.http.client.ws.DefaultWebSocketListener;
import com.ning.http.client.ws.WebSocket;

/**
 * @author Guilherme Pacheco
 */
public class RecallListener extends DefaultWebSocketListener {

  private static final Logger LOGGER = LoggerFactory.getLogger(RecallListener.class);
  private WebSocket webSocket;

  @Override
  public void onMessage(String message) {
    LOGGER.info("Recall: {}", message);
  }

  @Override
  public void onPing(byte[] message) {
    LOGGER.info("PING...");
  }

  @Override
  public void onPong(byte[] message) {
    LOGGER.info("PONG...");
  }

  @Override
  public void onOpen(WebSocket webSocket) {
    webSocket.sendMessage("Cliente conectado");
    this.webSocket = webSocket;
  }

  public void send() {
    webSocket.sendMessage("TESTE");
  }

}
