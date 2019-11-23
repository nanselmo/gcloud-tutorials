package com.google.codeu;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class GreeterTest {

  @Test
  public void testGreeting() {
    Greeter greeter = new Greeter();

    String greeting = greeter.greet("Ada");

    Assert.assertEquals("Hello Ada", greeting);
  }

  @Test
  public void testGreetingTrimsWhitespace() {
      Greeter greeter = new Greeter();

      String greeting = greeter.greet("   Ada   ");

      // Whitespace should be trimmed
      Assert.assertEquals("Hello Ada", greeting);
  }
}