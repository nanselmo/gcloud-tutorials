# Test Driven Development - Calendar

**Prerequisite:** Read the intro walkthrough first!

## Getting Started

Last week, you wrote and deployed server code, and you wrote client-side code that accessed your server.

This week, you'll use test-driven development to take your server code to the next level using data structures and algorithms.

You can return to this walkthrough anytime by running this command:

```bash
teachme calendar-walkthrough.md
```

Click the **Start** button to begin!

## Scenario

You're working on the calendar team and are responsible for adding the "find a
meeting" feature. Using the existing API, you'll need to implement a feature
that given meeting information, find all times that the meeting can happen.

### Objective

Your main objective is to implement `query()` in `StudentFindMeetingQuery.java`.
There is a `TODO` in the function to show you exactly what you need to
implement.

Your implementation must pass every test in `FindMeetingQueryTests.java` before
the feature will be considered complete.

To run the tests, execute this command:

```bash
mvn test
```

When the tests pass, you can be confident that your code works!

## Pull Request

TODO: instructions for creating a pull request

## Web Application

The code you wrote can be used in many contexts: from tests, from a desktop Java application, from server-side Java, etc.

This project contains a bare-bones web application that uses HTML, JavaScript, and a servlet to allow users to interact with the code you just wrote. This code is already written! You can imagine you worked on a team where you were responsible for the algorithm, and somebody else was responsible for the web application that calls your algorithm.

To run the web application, run a server:

```bash
mvn appengine:devserver
```

Then open the web preview to view a webpage that shows a user interface that provides access to the algorithm you wrote!

## Finishing Up

<walkthrough-conclusion-trophy></walkthrough-conclusion-trophy>

You've now seen unit testing, and you've used data structures to write an algorithm.

If you have time left over this week and you're looking for a challenge, consider improving your algorithm or sprucing up the web application. Some things to consider:

- Where should invalid data be handled?
- What's the algorithmic complexit of your algorithm? How much memory does it use? Can you improve it?
- What tests can you add?