package br.com.devsource.integration.server.handlers;

import java.time.LocalDateTime;

import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.Request;
import org.glassfish.grizzly.http.server.Response;

/**
 * @author Guilherme Pacheco
 */
public class TimeHanlder extends HttpHandler {

  @Override
  public void service(Request request, Response response) throws Exception {
    final String date = LocalDateTime.now().toString();
    response.setContentType("text/plain");
    response.setContentLength(date.length());
    response.getWriter().write(date);
  }

}
