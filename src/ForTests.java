import java.util.Scanner;

public class ForTests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine().trim();
        String str2 = scanner.nextLine().trim();
        int val1, val2;
        try {
            RomanNumeral romanNumeral1 = RomanNumeral.valueOf(str1);
            val1 = romanNumeral1.getValue();
            RomanNumeral romanNumeral2 = RomanNumeral.valueOf(str2);
            val2 = romanNumeral2.getValue();
        } catch (IllegalArgumentException e) {
            val1 = Integer.parseInt(str1);
            val2 = Integer.parseInt(str2);
        }
        System.out.println(val1 + val2);
    }
}
