package br.com.devsource.integration.client;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.ws.WebSocketUpgradeHandler;

/**
 * @author Guilherme Pacheco
 */
public class IntegrationClient {

  private static final String HOST = "ws://localhost:8080/recall";
  private AsyncHttpClient asyncHttpClient;
  private RecallListener listener;

  private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationClient.class);

  public IntegrationClient() throws Exception {
    AsyncHttpClientConfig config = new AsyncHttpClientConfig.Builder().build();
    asyncHttpClient = new AsyncHttpClient(config);
  }

  private void connect() throws InterruptedException, ExecutionException {
    listener = new RecallListener();
    WebSocketUpgradeHandler handler = new WebSocketUpgradeHandler.Builder()
        .addWebSocketListener(listener).build();
    asyncHttpClient.prepareGet(HOST).execute(handler).get();
  }

  public void send() throws Exception {
    connect();
    while (true) {
      listener.send();
      try {
        Thread.sleep(2000);
      } catch (InterruptedException ex) {
        LOGGER.error(ex.getMessage());
        connect();
      }
    }
  }

  public static void main(String[] args) throws Exception {
    IntegrationClient client = new IntegrationClient();
    client.send();
  }

}
