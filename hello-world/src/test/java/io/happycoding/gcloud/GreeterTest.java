package io.happycoding.gcloud;

import org.junit.Assert;
import org.junit.Test;

public class GreeterTest {

 @Test
 public void testGetGreetingMessage(){
   Greeter greeter = new Greeter("Hello");
   
   String greetingMessage = greeter.getGreetingMessage("world");

   Assert.assertEquals("Hello world!", greetingMessage);
 }

 @Test
 public void testGetGreetingMessage_inputTrimmed(){
   Greeter greeter = new Greeter("   Hello   ");
   
   String greetingMessage = greeter.getGreetingMessage("   world   ");

   Assert.assertEquals("Hello world!", greetingMessage);
 }
}