package ConditionalStatements.MoreExercise;

import java.util.Scanner;

public class PipesInPool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int v = Integer.parseInt(scanner.nextLine());
        int p1 = Integer.parseInt(scanner.nextLine());
        int p2 = Integer.parseInt(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());

        double p1h = p1 * h;
        double p2h = p2 * h;

        double p12h = p1h + p2h;
        double p1Contribution = (p1h / p12h) * 100;
        double p2Contribution = (p2h / p12h) * 100;
        double poolFilled = (p12h / v) * 100;
        char percent = '%';

        if (p12h <= v) {

            System.out.printf("The pool is %.2f%c full. Pipe 1: %.2f%c. Pipe 2: %.2f%c.", poolFilled, percent, p1Contribution, percent, p2Contribution, percent);
        } else {
            double diff = Math.abs(p12h - v);
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", h, diff);

        }
    }
}




