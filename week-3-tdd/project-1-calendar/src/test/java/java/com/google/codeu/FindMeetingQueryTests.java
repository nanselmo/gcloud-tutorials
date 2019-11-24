package com.google.codeu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** */
@RunWith(JUnit4.class)
public final class FindMeetingQueryTests {
  // TODO(student): Replace the type with your implementation.
  private final FindMeetingQuery query = new SampleFindMeetingQuery();

  // Use an array list so that it is easy to index the options when evaluating the results.
  private final List<TimeRange> options = new ArrayList<>();

  // Some people that we can use in our tests.
  private final Person personA = new Person("Person A");
  private final Person personB = new Person("Person B");

  @Before
  public void setUp() {
    options.clear();
  }

  @Test
  public void optionsForNoAttendees() {
    final Calendar calendar = new Calendar();

    final MeetingRequest request =
        request(calendar, restrictions(restriction(0, 1000)), duration(100), attendees());

    query.query(calendar, request, options);
    Assert.assertEquals(1, options.size());
    Assert.assertEquals(option(0, 1000), options.get(0));
  }

  @Test
  public void noOptionsForTooLongOfARequest() {
    final Calendar calendar = new Calendar();

    // The duration should be longer than all the restrictions so that there will never be an option
    // available, regardless of the calendar in the calendar.
    final MeetingRequest request =
        request(calendar, restrictions(restriction(0, 100)), duration(1000), attendees(personA));

    query.query(calendar, request, options);
    Assert.assertEquals(0, options.size());
  }

  @Test
  public void eventSplitsRestriction() {
    // Add an event that will occur in the middle of the restricted time. We should see therefore
    // see two options, before and after our event.
    final Calendar calendar = new Calendar(event("Event 1", 500, 600, personA));

    final MeetingRequest request =
        request(calendar, restrictions(restriction(0, 1000)), duration(100), attendees(personA));

    query.query(calendar, request, options);

    // Our options should be in order, so we can assume the order when checking the results.
    Assert.assertEquals(2, options.size());
    Assert.assertEquals(option(0, 500), options.get(0));
    Assert.assertEquals(option(600, 1000), options.get(1));
  }

  @Test
  public void everyAttendeeIsConsidered() {
    // Have each person have different events. We should see three options because each person has
    // split the restricted times.
    final Calendar calendar =
        new Calendar(event("Event 1", 200, 400, personA), event("Event 2", 500, 700, personB));

    final MeetingRequest request =
        request(calendar, restrictions(restriction(0, 1000)), duration(100), attendees(personA, personB));

    query.query(calendar, request, options);

    // Our options should be in order, so we can assume the order when checking the results.
    Assert.assertEquals(3, options.size());
    Assert.assertEquals(option(0, 200), options.get(0));
    Assert.assertEquals(option(400, 500), options.get(1));
    Assert.assertEquals(option(700, 1000), options.get(2));
  }

  @Test
  public void overlappingEvents() {
    // Have an event for each person, but have their events overlap. We should only see two options.
    final Calendar calendar =
        new Calendar(event("Event 1", 200, 500, personA), event("Event 2", 400, 800, personB));

    final MeetingRequest request =
        request(calendar, restrictions(restriction(0, 1000)), duration(100), attendees(personA, personB));

    query.query(calendar, request, options);

    // Our options should be in order, so we can assume the order when checking the results.
    Assert.assertEquals(2, options.size());
    Assert.assertEquals(option(0, 200), options.get(0));
    Assert.assertEquals(option(800, 1000), options.get(1));
  }

  @Test
  public void nestedEvents() {
    // Have an event for each person, but have one person's event fully contain another's event. We
    // should see two options.
    final Calendar calendar =
        new Calendar(event("Event 1", 200, 800, personA), event("Event 2", 400, 600, personB));

    final MeetingRequest request =
        request(calendar, restrictions(restriction(0, 1000)), duration(100), attendees(personA, personB));

    query.query(calendar, request, options);

    // Our options should be in order, so we can assume the order when checking the results.
    Assert.assertEquals(2, options.size());
    Assert.assertEquals(option(0, 200), options.get(0));
    Assert.assertEquals(option(800, 1000), options.get(1));
  }

  @Test
  public void doubleBookedPeople() {
    // Have one person, but have them registered to attend two events at the same time.
    final Calendar calendar =
        new Calendar(event("Event 1", 200, 600, personA), event("Event 2", 400, 800, personA));

    final MeetingRequest request =
        request(calendar, restrictions(restriction(0, 1000)), duration(100), attendees(personA));

    query.query(calendar, request, options);

    // Our options should be in order, so we can assume the order when checking the results.
    Assert.assertEquals(2, options.size());
    Assert.assertEquals(option(0, 200), options.get(0));
    Assert.assertEquals(option(800, 1000), options.get(1));
  }

  @Test
  public void ignoresPeopleNotAttending() {
    // Add an event, but make the only attendee someone different from the person looking to book
    // a meeting. This event should not affect the booking.
    final Calendar calendar = new Calendar(event("Event 1", 500, 600, personA));

    final MeetingRequest request =
        request(calendar, restrictions(restriction(0, 1000)), duration(100), attendees(personB));

    query.query(calendar, request, options);
    Assert.assertEquals(option(0, 1000), options.get(0));
  }

  @Test
  public void noConflicts() {
    final Calendar calendar = new Calendar();

    final MeetingRequest request =
        request(
            calendar,
            restrictions(restriction(0, 1000), restriction(1500, 2000)),
            duration(100),
            attendees(personA, personB));

    query.query(calendar, request, options);

    // Our options should match our restrictions. Our options should be in order, so we can assume
    // the order when checking the results.
    Assert.assertEquals(2, options.size());
    Assert.assertEquals(option(0, 1000), options.get(0));
    Assert.assertEquals(option(1500, 2000), options.get(1));
  }

  private static MeetingRequest request(
      Calendar calendar, TimeRange[] restrictions, long duration, Person[] attendees) {
    return new MeetingRequest(calendar, restrictions, duration, attendees);
  }

  private static TimeRange option(long start, long end) {
    return new TimeRange(start, end);
  }

  private static TimeRange[] restrictions(TimeRange... restrictions) {
    return restrictions;
  }

  private static TimeRange restriction(long start, long end) {
    return new TimeRange(start, end);
  }

  private static long duration(long duration) {
    return duration;
  }

  private static Person[] attendees(Person... attendees) {
    return attendees;
  }

  private static CalendarEvent event(String title, long start, long end, Person... attendees) {
    return new CalendarEvent(title, new TimeRange(start, end), attendees);
  }
}