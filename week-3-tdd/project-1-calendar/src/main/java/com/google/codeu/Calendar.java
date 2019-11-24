package com.google.codeu;

import java.util.Collection;

/**
 * A collection of events with a functions to search for events.
 */
public class Calendar {

  private CalendarEvent[] events;

  public Calendar(CalendarEvent... events) {
    this.events = events;
  }

  /**
   * Get all events that overlap with |during| and add them to |events|. |during| and |events| must
   * be non-null.
   */
  void getEventsBetween(TimeRange during, Collection<CalendarEvent> out){
    for (final CalendarEvent event : events) {
      if (during.overlaps(event.when)) {
        out.add(event);
      }
    }
  }
}