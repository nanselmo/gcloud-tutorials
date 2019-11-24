package com.google.codeu.servlets;

import com.google.codeu.FindMeetingQuery;
import com.google.codeu.MeetingRequest;
import com.google.codeu.SampleFindMeetingQuery;
import com.google.codeu.TimeRange;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calendar")
public class CalendarServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


    Gson gson = new Gson();

    MeetingRequest mr = gson.fromJson(request.getReader(), MeetingRequest.class);
    FindMeetingQuery findMeetingQuery = new SampleFindMeetingQuery();
    List<TimeRange> answer = new ArrayList<>();
    findMeetingQuery.query(mr.calendar, mr, answer);


    String jsonResponse = gson.toJson(answer);
    response.setContentType("application.json;");

    
    response.getWriter().println(jsonResponse);



  //  FindMeetingQuery findMeetingQuery = new SampleMeetingQuery();
  }


}