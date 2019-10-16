package io.happycoding.gcloud;

/**
 * Class responsible for creating greeting messages.
 */
public class Greeter {

  private final String salutation;

  /**
   * Constructs a new Greeter using the supplied salutation.
   */
  public Greeter(String salutation) {
    this.salutation = salutation.trim();
  }

  /**
   * Returns a message that greets the supplied name.
   */
  public String getGreetingMessage(String name){
    // TODO: Fix this code so the tests pass!
    return salutation + name.trim() + "!";
  }
}