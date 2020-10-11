import java.util.Arrays;
import java.util.Scanner;

public class TestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        System.out.println(str1);
        System.out.println(containOneOperator(str1));
    }

    public static boolean containOneOperator(String inputStr) {
        String[] inputStrArr = inputStr.split("");
        System.out.println(Arrays.toString(inputStrArr));
        int amountOfOperators = 0;
        for (String s: inputStrArr) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                amountOfOperators++;
            }
        }
        return amountOfOperators == 1;
    }

    public static String whichOperator(String inputStr) {
        String[] arithmeticOperators = {"+", "-", "/", "*"};
        String requiredOperator = "";
        for (String s: arithmeticOperators) {
            if (inputStr.contains(s)) {
                requiredOperator = s;
                break;
            }
        }
        return requiredOperator;
    }

    public static String[] splitIntoTwoTerms(String inputStr, String operator) {
        String[] membersOfExpression = new String[2];
        int indexOfOperator = inputStr.indexOf(operator);
        membersOfExpression[0] = inputStr.substring(0, indexOfOperator);
        membersOfExpression[1] = inputStr.substring(indexOfOperator + 1);
        return membersOfExpression;
    }
}
