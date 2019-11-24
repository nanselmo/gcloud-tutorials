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

    // Convert the JSON to an instance of MeetingRequest.
    MeetingRequest meetingRequest = gson.fromJson(request.getReader(), MeetingRequest.class);

    // Find the possible meeting times.
    FindMeetingQuery findMeetingQuery = new SampleFindMeetingQuery();
    List<TimeRange> answer = new ArrayList<>();
    findMeetingQuery.query(mr.calendar, mr, answer);

    // Convert the times to JSON
    String jsonResponse = gson.toJson(answer);

    // Send the JSON back as the response
    response.setContentType("application.json;");
    response.getWriter().println(jsonResponse);
  }
}