package ConditionalStatements.Lab;

import java.util.Scanner;
import java.util.function.DoublePredicate;

public class AreaOfFigures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Прочитаме вида на фигурата

        String figure = scanner.nextLine();
        double result = 0;

        // Правим проверка за вида на фигурата
        // прочитаме размерите на конкретната фигура

         if (figure.equals("square")) {
            double a = Double.parseDouble(scanner.nextLine());
            result = a * a;

        } else if (figure.equals("rectangle")) {
            double a = Double.parseDouble(scanner.nextLine());
            double b = Double.parseDouble(scanner.nextLine());
            result = a * b;
        } else if (figure.equals("circle")) {
            double r = Double.parseDouble(scanner.nextLine());
            result = Math.PI * Math.pow(r, 2);
        } else if (figure.equals("triangle")) {
            double a = Double.parseDouble(scanner.nextLine());
            double h = Double.parseDouble(scanner.nextLine());
            result = (a * h) / 2;
        }
        System.out.printf("%.3f", result);


    }
}
