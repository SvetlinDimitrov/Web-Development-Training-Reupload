public class EndsWithPeriodExpression implements AbstractExpression {

    private final FirstLetterLowerCaseExpression firstLetterLowerCaseExpression = new FirstLetterLowerCaseExpression();

    @Override
    public String interpret(String context) {
        if(!context.endsWith(".")) {
            context = context + ".";
        }
        return firstLetterLowerCaseExpression.interpret(context);
    }
}
