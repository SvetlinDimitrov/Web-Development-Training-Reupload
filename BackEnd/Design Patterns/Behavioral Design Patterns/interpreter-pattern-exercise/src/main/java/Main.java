public class Main {

  public static void main(String[] args) {

    String context = "this is a a sentence";

    AbstractExpression expression = new EndsWithPeriodExpression();
    context = expression.interpret(context);

    System.out.println(context);

  }

}
