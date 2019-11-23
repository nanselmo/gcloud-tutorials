package com.google.codeu;

import experimental.users.vaage.codeu.assignments.calendar.api.Calendar;
import experimental.users.vaage.codeu.assignments.calendar.api.FindMeetingQuery;
import experimental.users.vaage.codeu.assignments.calendar.api.MeetingRequest;
import experimental.users.vaage.codeu.assignments.calendar.api.Person;
import experimental.users.vaage.codeu.assignments.calendar.api.TimeRange;
import java.util.Collection;

final class StudentFindMeetingQuery implements FindMeetingQuery {
  public void query(Calendar calendar, MeetingRequest request, Collection<TimeRange> options) {
    assert calendar != null;

    // TODO(you): Implement this method and add all options to |options|. The results should be
    // added in order by start time.
  }
}