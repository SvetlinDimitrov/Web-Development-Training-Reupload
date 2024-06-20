package org.enum1;

public enum AllAnimals implements Animals{
  // The following are the defined objects of the enum AllAnimals
  // if we use abstract method in enum, we have to define the abstract method in each object of the enum
//  BEAR {
//    @Override
//    void sleep() {
//
//    }
//  },
  BEAR("meat" , 20L),
  ELEPHANT("grass", 60L),
  LION("meat", 30L),
  TIGER("meat" , 25L),
  WOLF("meat", 15L);
  // after the last object, there is a semicolon (;) after witch we can add methods and fields

  final String type;
  final Long longevity;

  AllAnimals(String type, Long longevity) {
    this.type = type;
    this.longevity = longevity;
  }

  @Override
  public void lifeStyle() {
    eatSecretly();
    System.out.println(name() + " animals eat " + type + " as food");
    System.out.println("They live for " + longevity + " years");
  }


  private void eatSecretly(){
    System.out.println(name() + " animals eat secretly");
  }

  //We can define abstract methods in enum, but now we have to define the abstract method in each object of the enum
//  abstract void sleep();

}
