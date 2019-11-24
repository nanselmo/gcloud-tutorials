function addEventInput() {
  const title = document.createElement('input');
  title.setAttribute('type', 'text');
  title.setAttribute('placeholder', 'Event Title');

  const startTime = document.createElement('input');
  startTime.setAttribute('type', 'number');
  startTime.setAttribute('placeholder', 'Start Time');

  const endTime = document.createElement('input');
  endTime.setAttribute('type', 'number');
  endTime.setAttribute('placeholder', 'End Time');

  const attendees = document.createElement('input');
  attendees.setAttribute('type', 'text');
  attendees.setAttribute('placeholder', 'Ada, Grace, Alan');

  const eventContainer = document.createElement('div');
  eventContainer.className = 'event';
  eventContainer.appendChild(title);
  eventContainer.appendChild(document.createElement('br'));
  eventContainer.appendChild(startTime);
  eventContainer.appendChild(document.createTextNode(' - '));
  eventContainer.appendChild(endTime);
  eventContainer.appendChild(document.createElement('br'));
  eventContainer.appendChild(document.createTextNode('Attendees: '));
  eventContainer.appendChild(attendees);

  const eventsContainer = document.getElementById('events');
  eventsContainer.appendChild(eventContainer);
}

function addRestrictionInput() {
  const startTime = document.createElement('input');
  startTime.setAttribute('type', 'number');
  startTime.setAttribute('placeholder', 'Start');

  const endTime = document.createElement('input');
  endTime.setAttribute('type', 'number');
  endTime.setAttribute('placeholder', 'End');

  const restrictionContainer = document.createElement('div');
  restrictionContainer.className = 'restriction';
  restrictionContainer.appendChild(startTime);
  restrictionContainer.appendChild(document.createTextNode(' - '));
  restrictionContainer.appendChild(endTime);
  restrictionContainer.appendChild(document.createElement('br'));

  const restrictionsContainer = document.getElementById('restrictions');
  restrictionsContainer.appendChild(restrictionContainer);
}

function getMeetingTimes() {
  const events = [];
  // TODO: consider cleaning this up, using a class on each div?
  const eventInputs = document.getElementById('events').getElementsByTagName('input');
  for(let i = 0; i < eventInputs.length; i += 4) {
    const title = eventInputs[i].value;
    const start = eventInputs[i + 1].value;
    const end = eventInputs[i + 2].value;
    // comma-separated list of names
    const attendeesNamesString = eventInputs[i + 3].value;
    // split it into an array of names
    const attendeesNamesArray = attendeesNamesString.split(/\s*,\s*/);
    // convert it to an array of Person instances
    const personArray = attendeesNamesArray.map((name) => { return new Person(name); });
    events.push(new CalendarEvent(title, new TimeRange(start, end), personArray));
  }

  const restrictions = [];
  const restrictionInputs = document.getElementById('restrictions').getElementsByTagName('input');
  for(let i = 0; i < restrictionInputs.length; i += 2) {
    const start = restrictionInputs[i].value;
    const end = restrictionInputs[i + 1].value;
    const timeRange = new TimeRange(start, end);
    restrictions.push(timeRange);
  }

  const duration = document.getElementById('duration').value;

  // comma-separated list of names
  const attendeesNamesString = document.getElementById('attendees').value;
  // split it into an array of names
  const attendeesNamesArray = attendeesNamesString.split(/\s*,\s*/);
  // convert it to an array of Person instances
  const attendees = attendeesNamesArray.map((name) => { return new Person(name); });

  const calendar = new Calendar(events);

  const meetingRequest = new MeetingRequest(calendar, restrictions, duration, attendees);

  const json = JSON.stringify(meetingRequest);
  console.log('request: ' + json);

  fetch('/calendar', {method: 'POST', body: json})
  .then((response) => { 
    console.log('Response: ' + response);
    return response.json();
  })
  .then((timeRanges) => {
    const resultsContainer = document.getElementById('results');
    // clear out any old results
    resultsContainer.innerHTML = '';
    // add results to the page
    timeRanges.forEach((timeRange) => {
        resultsContainer.innerHTML += '<li>' + timeRange.start + " - " + timeRange.end + '</li>';
    });
  });

}

class Calendar {
  constructor(events) {
    this.events = events;
  }
}

class CalendarEvent {
  constructor(title, when, attendees) {
    this.title = title;
    this.when = when;
    this.attendees = attendees;
  }
}

class MeetingRequest {
  constructor(calendar, restrictions, duration, attendees) {
    this.calendar = calendar;
    this.restrictions = restrictions;
    this.duration = duration;
    this.attendees = attendees;
  }
}

class TimeRange {
  constructor(start, end) {
    this.start = start;
    this.end = end;
  }
}

class Person {
  constructor(name) {
    this.name = name;
  }
}