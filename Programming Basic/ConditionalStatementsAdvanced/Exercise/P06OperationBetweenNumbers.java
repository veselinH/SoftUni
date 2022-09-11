package ConditionalStatementsAdvanced.Exercise;

import java.util.Scanner;

public class P06OperationBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        char operator = scanner.nextLine().charAt(0);
        double plus = num1 + num2;
        double minus = num1 - num2;
        double multiplied = num1 * num2;


        switch (operator) {
            case '+':
                if (plus % 2 == 0) {
                    System.out.printf("%d %c %d = %.0f - even", num1, operator, num2, plus);
                } else {
                    System.out.printf("%d %c %d = %.0f - odd", num1, operator, num2, plus);
                }
                break;
            case '-':
                if (minus % 2 == 0) {
                    System.out.printf("%d %c %d = %.0f - even", num1, operator, num2, minus);
                } else {
                    System.out.printf("%d %c %d = %.0f - odd", num1, operator, num2, minus);
                }
                break;
            case '*':
                if (multiplied % 2 == 0) {
                    System.out.printf("%d %c %d = %.0f - even", num1, operator, num2, multiplied);
                } else {
                    System.out.printf("%d %c %d = %.0f - odd", num1, operator, num2, multiplied);
                }
                break;
            case '/':
                if (num2 == 0) {
                    System.out.printf("Cannot divide %d by zero", num1);
                } else {
                    double divide = num1 * 1.0 / num2;

                    System.out.printf("%d %c %d = %.2f", num1, operator, num2, divide);
                }
                break;
            case '%':
                if (num2 == 0) {
                    System.out.printf("Cannot divide %d by zero", num1);
                } else {
                    double modular = num1 % num2;
                    System.out.printf("%d %c %d = %.0f", num1, operator, num2, modular);
                }
                break;

        }

    }
}
