package com.google.codeu;

public final class MeetingRequest {
  public final Calendar calendar;
  public final TimeRange[] restrictions;
  public final long duration;
  public final Person[] attendees;

  public MeetingRequest(Calendar calendar, TimeRange[] restrictions, long duration, Person[] attendees) {
    this.calendar = calendar;
    this.restrictions = restrictions;
    this.duration = duration;
    this.attendees = attendees;
  }
}