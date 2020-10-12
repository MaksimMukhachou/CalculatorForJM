public class InputExpression {
    private String inputExpression;

    public InputExpression(String inputExpression) throws InputExpressionException {
        this.inputExpression = inputExpression;
        if (!containOneOperator()) {
            throw new InputExpressionException("Wrong number of operators.");
        }
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

    private String firstTermString() {
        int indexOfOperator = inputExpression.indexOf(getOperator());
        return inputExpression.substring(0, indexOfOperator).trim();
    }

    public int getFirstTerm() throws NumberFormatException {
        if (isRoman()) {
            return RomanNumeral.valueOf(firstTermString()).getValue();
        } else {
            return Integer.parseInt(firstTermString());
        }
    }

    private String secondTermString() {
        int indexOfOperator = inputExpression.indexOf(getOperator());
        return inputExpression.substring(indexOfOperator + 1).trim();
    }

    public int getSecondTerm() throws NumberFormatException {
        if (isRoman()) {
            return RomanNumeral.valueOf(secondTermString()).getValue();
        } else {
            return Integer.parseInt(secondTermString());
        }
    }

    public boolean isRoman() {
        try {
            RomanNumeral.valueOf(firstTermString());
            RomanNumeral.valueOf(secondTermString());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

}
