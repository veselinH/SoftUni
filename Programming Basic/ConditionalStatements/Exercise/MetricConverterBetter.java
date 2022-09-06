package ConditionalStatements.Exercise;

import java.util.Scanner;

public class MetricConverterBetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        String output = scanner.nextLine();

        if (input.equals("m")) {
            num *= 100;

        } else if (input.equals("mm")) {
            num /= 100;

        }
        if (output.equals("m")) {
            num /= 100;

        } else if (output.equals("mm")) {
            num *= 100;

        }
        System.out.printf("%.3f", num);
    }
}
