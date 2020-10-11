import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputData = scanner.nextLine();
        try {
            InputExpression inputExpression = new InputExpression(inputData);
            int firstTerm = inputExpression.getFirstTerm();
            int secondTerm = inputExpression.getSecondTerm();
            String operator = inputExpression.getOperator();
            Calculation calculation = new Calculation(firstTerm, secondTerm, operator);
            System.out.println(calculation.result());
        } catch (InputExpressionException | NumberFormatException e) {
            System.err.println("Incorrectly entered data. " + e.getMessage());
        }
    }
}
