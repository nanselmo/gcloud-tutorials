package com.google.codeu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This is one implementation of the FindMeetingQuery feature. This SHOULD NOT be given to students
 * before they have finished the assignment.
 */
public class SampleFindMeetingQuery implements FindMeetingQuery {
  private static final class OrderByStart implements Comparator<TimeRange> {
    @Override
    public int compare(TimeRange a, TimeRange b) {
      return Long.compare(a.start, b.start);
    }
  }

  public void query(Calendar calendar, MeetingRequest request, Collection<TimeRange> options) {
    assert calendar != null;

    final Set<Person> attendees = new HashSet<>(Arrays.asList(request.attendees));

    final Collection<CalendarEvent> scratchEvents = new ArrayList<>();
    final Collection<CalendarEvent> conflicts = new ArrayList<>();

    // Get all the events that we will conflict with.
    for (final TimeRange option : request.restrictions) {
      calendar.getEventsBetween(option, scratchEvents);
      for (final CalendarEvent event : scratchEvents) {
        if (intersects(attendees, event.attendees)) {
          conflicts.add(event);
        }
      }
    }

    // Prime the read collection with our initial options (the restrictions).
    final List<TimeRange> scratchOptionsRead = new ArrayList<>(Arrays.asList(request.restrictions));
    final List<TimeRange> scratchOptionsWrite = new ArrayList<>();

    // The events are what change our options, so for each event, apply its limitations upon our
    // options.
    for (final CalendarEvent event : conflicts) {
      for (final TimeRange option : scratchOptionsRead) {
        split(option, event.when, scratchOptionsWrite);
      }

      // Reset by making the output of this iteration the input for the next iteration.
      scratchOptionsRead.clear();
      scratchOptionsRead.addAll(scratchOptionsWrite);
      scratchOptionsWrite.clear();
    }

    // Before we accept any option, filter out the options that are too small.
    for (final TimeRange option : scratchOptionsRead) {
      if (option.duration() >= request.duration) {
        scratchOptionsWrite.add(option);
      }
    }

    // |scratchOptionsWrite| now contains all our options. Now all we need to do is sort them by
    // start time.
    scratchOptionsWrite.sort(new OrderByStart());
    options.addAll(scratchOptionsWrite);
  }

  /**
   * Split |source| into zero, one, or two ranges based on where |cut| sits relative to |source|.
   * The results of a split should be added to |parts|.
   */
  private static void split(TimeRange source, TimeRange cut, Collection<TimeRange> parts) {
    // The cut contains all of the source, so it would leave nothing.
    if (cut.contains(source)) {
      return;
    }

    // If we are inside of the source, then we are cutting it into two pieces.
    if (source.contains(cut)) {
      parts.add(new TimeRange(source.start, cut.start));
      parts.add(new TimeRange(cut.end, source.end));
      return;
    }

    // Are we trimming the left side?
    if (cut.contains(source.start)) {
      parts.add(new TimeRange(cut.end, source.end));
      return;
    }

    // Are we trimming the right side?
    if (cut.contains(source.end)) {
      parts.add(new TimeRange(source.start, cut.start));
      return;
    }

    // Final Case: no overlap.
    parts.add(source);
  }

  /**
   * Checks if these two collections overlap/intersect. We assume that collection can support
   * efficient contains().
   */
  private static <T> boolean intersects(Collection<T> collection, T... options) {
    for (T option : options) {
      if (collection.contains(option)) {
        return true;
      }
    }

    return false;
  }
}