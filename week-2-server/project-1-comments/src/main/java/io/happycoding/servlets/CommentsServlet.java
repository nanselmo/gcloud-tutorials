package io.happycoding.servlets;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/comments")
public class CommentsServlet extends HttpServlet {

  private List<String> comments = new ArrayList<>();

  @Override
  public void init(){
    comments.add("Hello!");
    comments.add("Hey.");
    comments.add("Hi");
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("application/json;");

    response.getWriter().println("[");
    for(int i = 0; i < comments.size(); i++) {
      String comment = comments.get(i);
      response.getWriter().println("\"" + comment + "\"");

      // don't print a comma after the last comment
      if(i < comments.size() - 1){
        response.getWriter().println(",");
      }
    }
    response.getWriter().println("]");
  }

@Override
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
  String message = request.getParameter("message");
  comments.add(message);
  response.sendRedirect("/index.html");
}


 
}