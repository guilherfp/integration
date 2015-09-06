package br.com.devsource.integration.server;

import org.glassfish.grizzly.http.server.HttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    server.getServerConfiguration().addHttpHandler(new TimeHanlder(), "/time");
  }

  public void start() {
    try {
      LOGGER.info("Iniciando servidor");
      running = true;
      do {
        server.start();
      } while (running);
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
