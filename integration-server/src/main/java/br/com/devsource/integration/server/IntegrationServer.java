package br.com.devsource.integration.server;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.NetworkListener;
import org.glassfish.grizzly.websockets.WebSocketAddOn;
import org.glassfish.grizzly.websockets.WebSocketEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.devsource.integration.server.application.RecallApplication;
import br.com.devsource.integration.server.handlers.TimeHanlder;

/**
 * @author Guilherme Pacheco
 */
public class IntegrationServer {

  private HttpServer server;
  private boolean running;

  private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationServer.class);

  public IntegrationServer() {
    server = HttpServer.createSimpleServer();
    WebSocketAddOn addOn = new WebSocketAddOn();
    for (NetworkListener listener : server.getListeners()) {
      listener.registerAddOn(addOn);
    }
    server.getServerConfiguration().addHttpHandler(new TimeHanlder(), "/time");
    WebSocketEngine.getEngine().register("/", "/recall", new RecallApplication());
  }

  public void start() {
    try {
      LOGGER.info("Iniciando servidor");
      running = true;
      do {
        server.start();
      } while (running);
      LOGGER.info("Servidor finalizado");
    } catch (Exception ex) {
      LOGGER.error("Erro ao iniciar servidor: {}", ex.getMessage());
    }
  }

  public void stop() {
    running = false;
  }

  public static void main(String[] args) {
    IntegrationServer integrationServer = new IntegrationServer();
    integrationServer.start();
  }

}
