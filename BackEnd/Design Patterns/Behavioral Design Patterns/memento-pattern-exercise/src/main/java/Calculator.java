public class Calculator {

  public static void main(String[] args) {
    History history = new History();
    Adder adder = new Adder();
    adder.add(10);
    System.out.println(adder.getResult());

    adder.save(history);
    adder.add(20);
    System.out.println(adder.getResult());
    adder.undo(history.restore());
    System.out.println(adder.getResult());
  }

}
