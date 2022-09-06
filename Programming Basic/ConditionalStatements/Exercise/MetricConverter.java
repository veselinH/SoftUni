package ConditionalStatements.Exercise;

import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        String firstUnit = scanner.nextLine();
        String secondUnite = scanner.nextLine();

        if (firstUnit.equals("mm"))
            if (secondUnite.equals("m")) {

                System.out.printf("%.3f", number / 1000);

            } else if (secondUnite.equals("cm")) {
                System.out.printf("%.3f", number / 10);
            }
        if (firstUnit.equals("m"))
            if (secondUnite.equals("mm")) {
                System.out.printf("%.3f", number * 1000);
            } else if (secondUnite.equals("cm")) {
                System.out.printf("%.3f", number * 100);
            }
        if (firstUnit.equals("cm"))
            if (secondUnite.equals("m")) {
                System.out.printf("%.3f", number / 100);
            } else if (secondUnite.equals("mm")) {
                System.out.printf("%.3f", number * 10);
            }


    }
}
