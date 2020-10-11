public class InputExpression {
    private String inputExpression;
    private String operator;

    public InputExpression(String inputExpression) throws InputExpressionException {
        this.inputExpression = inputExpression;
        if (!containOneOperator()) {
            throw new InputExpressionException("Wrong number of operators.");
        }
        this.operator = getOperator();
    }

    private boolean containOneOperator() {
        String[] inputExpressionArray = inputExpression.split("");
        int amountOfOperators = 0;
        for (String s: inputExpressionArray) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                amountOfOperators++;
            }
        }
        return amountOfOperators == 1;
    }

    public String getOperator() {
        String[] arithmeticOperators = {"+", "-", "/", "*"};
        String requiredOperator = "";
        for (String s: arithmeticOperators) {
            if (inputExpression.contains(s)) {
                requiredOperator = s;
                break;
            }
        }
        return requiredOperator;
    }

    public int getFirstTerm() throws NumberFormatException{
        int indexOfOperator = inputExpression.indexOf(operator);
        String firstTermString = inputExpression.substring(0, indexOfOperator).trim();
        return Integer.parseInt(firstTermString);
    }

    public int getSecondTerm() throws NumberFormatException{
        int indexOfOperator = inputExpression.indexOf(operator);
        String secondTermString = inputExpression.substring(indexOfOperator + 1).trim();
        return Integer.parseInt(secondTermString);
    }
}
