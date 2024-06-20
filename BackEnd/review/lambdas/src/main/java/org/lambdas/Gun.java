package org.lambdas;

public class Gun implements Shootable {

  @Override
  public void fire() {
    System.out.println("Bang! from the Gun class.");
  }
}
