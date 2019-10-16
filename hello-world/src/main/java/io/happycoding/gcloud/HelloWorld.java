package io.happycoding.gcloud;

public class HelloWorld {
  public static void main(String... args){
    Greeter greeter = new Greeter("Hello");
    String greetingMessage = greeter.getGreetingMessage("world");
    System.out.println(greetingMessage);
  }
}