public class FirstLetterLowerCaseExpression implements AbstractExpression {
    private final NonRepeatedWordsExpression expression = new NonRepeatedWordsExpression();
    @Override
    public String interpret(String context) {
        context = context.substring(0,1).toUpperCase() + context.substring(1);
        return expression.interpret(context);
    }
}
