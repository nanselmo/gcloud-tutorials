# Test Driven Development - Intro

## Getting Started

Last week, you wrote and deployed server code, and you wrote client-side code that interacted with your server.

This week, you'll learn about test-driven development, and take your server code to the next level using data structures and algorithms.

You can return to this walkthrough anytime by running this command:

```bash
teachme tdd-intro-walkthrough.md
```

Click the **Start** button to begin!

## Unit Testing

As you wrote your code last week, you probably tested it manually by running a server, interacting with your HTML page, submitting data, and confirming that your code did what you expected. This works for small projects, but testing manually becomes difficult when you work on a team in larger codebases. Imagine you're on a team of 10 people, working on a project that contains 10,000 lines of code. How do you know a change you make doesn't break anything?

[Unit testing](https://en.wikipedia.org/wiki/Unit_testing) is a way to confirm your code works correctly, without running a whole server or manually interacting with a UI. Instead, you write a **unit test**, which is a program that tests out another program.

For example, open the `Greeter.java` file. This class creates greeting messages. How can we confirm that this code does what we expect?

Next, open the `GreeterTest.java` file. This class contains a unit test that confirms the behavior of the `Greeter` class.

To run the test, execute this command:

```bash
mvn test
```

This command will compile all the code, and then run the functions in the `GreeterTest` class. You should see this output:

```none
Results :
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

This means that the test passed!

## Test-driven Development

[Test-driven development](https://en.wikipedia.org/wiki/Test-driven_development) is used by many teams at Google. (TODO: is this true?) In test-driven development, we use tests to define the correct behavior of code, and then we write code that pass the tests.

Add this function to your `GreeterTest` class:

```java
@Test
public void testGreetingTrimsWhitespace() {
  Greeter greeter = new Greeter();

  String greeting = greeter.greet("   Ada   ");

  // Whitespace should be trimmed
  Assert.assertEquals("Hello Ada", greeting);
}
```

This function tests whether whitespace is trimmed from the `name` parameter. Save the file and run the tests again:

```bash
mvn test
```

You should now see this output:

```none
Results :
Failed tests:   testGreetingWhitespace(com.google.codeu.GreeterTest): expected:<Hello [Ada]> but was:<Hello [   Ada   ]>
Tests run: 2, Failures: 1, Errors: 0, Skipped: 0
BUILD FAILURE
```

This tells you that the `testGreetingWhitespace` test failed, because it was expecting `"Hello Ada"` but got `"Hello   Ada   "` instead.

Modify the `Greeter` class to properly trim whitespace so the tests pass.

Tests are useful for definining new desired behavior, and to confirm that new code doesn't break existing behavior.

**Practice:** If you want more practice, try writing a new test that confirms that symbols like `@#$%` are removed from the input, and then modify the code so the tests pass.

## Learn More

<walkthrough-conclusion-trophy></walkthrough-conclusion-trophy>

The examples above, and the projects this week, all use a library called **JUnit** to write unit tests. You can learn more about JUnit [here](https://junit.org/junit4/) or by Googling "JUnit tutorials" or terms like "JUnit confirm exception thrown" if you want to learn about a more specific feature of JUnit.