package com.google.codeu.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/data")
public class DataServlet extends HttpServlet {

  private int requestCount = 0;

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    requestCount++;
    
    response.setContentType("text/html;");
    response.getWriter().println(requestCount);
  }
}