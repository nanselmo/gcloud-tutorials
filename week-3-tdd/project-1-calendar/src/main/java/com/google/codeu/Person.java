package com.google.codeu;

// TODO: can we eliminate this calss and just use Strings?
public final class Person {
  public final String name;

  public Person(String name) {
    assert name != null;

    this.name = name;
  }

  @Override
  public int hashCode(){
      return name.hashCode();
  }

  @Override
  public boolean equals(Object other){
      return name.equals(((Person)other).name);
  }
}