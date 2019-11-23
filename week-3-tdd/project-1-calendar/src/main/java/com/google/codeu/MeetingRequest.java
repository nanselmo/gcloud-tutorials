package com.google.codeu;

public final class MeetingRequest {
  public final TimeRange[] restrictions;
  public final long duration;
  public final Person[] attendees;

  public MeetingRequest(TimeRange[] restrictions, long duration, Person[] attendees) {
    this.restrictions = restrictions;
    this.duration = duration;
    this.attendees = attendees;
  }
}