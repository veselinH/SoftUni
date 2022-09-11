package ConditionalStatementsAdvanced.MoreExercise;

import java.util.Scanner;

public class P06TruckDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        double kmPerMonth = Double.parseDouble(scanner.nextLine());

        double driverSalary = 0.00;

        switch (season) {
            case "Spring":
            case "Autumn":
                if (kmPerMonth <= 5000) {
                    driverSalary = (0.75 * kmPerMonth) * 4; // Цена на километър * изминалите километри за месец * 4 месеца
                } else if (kmPerMonth <= 10000) {
                    driverSalary = (0.95 * kmPerMonth) * 4;
                } else {
                    driverSalary = (1.45 * kmPerMonth) * 4;
                }
                break;
            case "Summer":
                if (kmPerMonth <= 5000) {
                    driverSalary = (0.90 * kmPerMonth) * 4;
                } else if (kmPerMonth <= 10000) {
                    driverSalary = (1.10 * kmPerMonth) * 4;
                } else {
                    driverSalary = (1.45 * kmPerMonth) * 4;
                }
                break;
            case "Winter":
                if (kmPerMonth <= 5000) {
                    driverSalary = (1.05 * kmPerMonth) * 4;
                } else if (kmPerMonth <= 10000) {
                    driverSalary = (1.25 * kmPerMonth) * 4;
                } else {
                    driverSalary = (1.45 * kmPerMonth) * 4;
                }
                break;
        }
        driverSalary *= 0.90; // 10% данъци
        System.out.printf("%.2f", driverSalary);
    }
}
