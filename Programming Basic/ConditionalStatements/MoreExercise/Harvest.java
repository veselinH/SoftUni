package ConditionalStatements.MoreExercise;

import java.util.Scanner;

public class Harvest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Прочитаме входа

        int x = Integer.parseInt(scanner.nextLine()); // лозето в кв.м
        double y = Double.parseDouble(scanner.nextLine()); // грозде за един кв.м
        int z = Integer.parseInt(scanner.nextLine()); // нужни литри вино
        int workers = Integer.parseInt(scanner.nextLine()); // брой работници

        // Изчисляваме

        double totalGrape = x * y;
        double wine = totalGrape * 0.40 / 2.5;

        if (wine >= z) {
            double wineFloored = Math.floor(wine);
            double wineLeft = Math.abs(wine - z);
            double wineLeftCeiled = Math.ceil(wineLeft);
            double wineForWorkers = wineLeft / workers;
            double wineForWorkersCeiled = Math.ceil(wineForWorkers);
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n", wineFloored);
            System.out.printf("%.0f liters left -> %.0f liters per person.", wineLeftCeiled, wineForWorkersCeiled);
        } else {
            double wineNeeded = Math.abs(z - wine);
            double wineNeededFloored = Math.floor(wineNeeded);
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", wineNeededFloored);
        }

    }
}
