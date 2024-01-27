public class Main {

  public static void main(String[] args) {
    Fan fan = new Fan(new LowState());
    fan.turnUp();
    fan.turnUp();
    fan.turnDown();
    fan.turnDown();
    fan.turnUp();
  }

}
