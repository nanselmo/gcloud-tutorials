package com.google.codeu;

import java.util.Collection;

/**
 * A collection of events with a functions to search for events.
 */
public interface Calendar {
  /**
   * Get all events that overlap with |during| and add them to |events|. |during| and |events| must
   * be non-null.
   */
  void getEventsBetween(TimeRange during, Collection<Event> events);
}