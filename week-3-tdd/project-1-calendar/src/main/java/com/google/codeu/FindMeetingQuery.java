package com.google.codeu;

import java.util.Collection;

/**
 * The common iterface for all implementations of the "find meeting" feature. Implementations should
 * not store any state between calls to query().
 */
public interface FindMeetingQuery {
  /**
   * Find all time ranges that a meeting could be scheduled for and add them to |options|.
   * Requirements:
   *   - options should be added to |options| ordered by start time
   *   - there should be no overlapping options
   *   - all attendees should be able to attend all options
   */
  void query(Calendar calendar, MeetingRequest request, Collection<TimeRange> options);
}