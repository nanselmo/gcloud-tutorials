package com.google.codeu;

import java.util.Arrays;

public final class Event {
  public final String title;
  public final TimeRange when;
  public final Person[] attendees;

  public Event(String title, TimeRange when, Person[] attendees) {
    assert title != null;
    assert when != null;
    assert attendees != null;

    this.title = title;
    this.when = when;
    this.attendees = Arrays.copyOf(attendees, attendees.length);
  }
}