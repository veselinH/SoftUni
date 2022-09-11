package ConditionalStatementsAdvanced.Exercise;

import java.util.Scanner;

public class P05Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String bulgaria = "Somewhere in Bulgaria";
        String balkans = "Somewhere in Balkans";
        String europe = "Somewhere in Europe";
        String camp = "Camp";
        String hotel = "Hotel";

        if (budget <= 100) {    // Somewhere in Bulgaria
            if (season.equals("summer")) {
                double spentMoney = budget * 0.30;
                System.out.printf("%s%n", bulgaria);
                System.out.printf("%s - %.2f", camp, spentMoney);
            } else {
                double spentMoney = budget * 0.70;
                System.out.printf("%s%n", bulgaria);
                System.out.printf("%s - %.2f", hotel, spentMoney);
            }
        } else if (budget <= 1000) {              // Somewhere in Balkans
            if (season.equals("summer")) {
                double spentMoney = budget * 0.40;
                System.out.printf("%s%n", balkans);
                System.out.printf("%s - %.2f", camp, spentMoney);
            } else {
                double spentMoney = budget * 0.80;
                System.out.printf("%s%n", balkans);
                System.out.printf("%s - %.2f", hotel, spentMoney);
            }
        } else {                               // Somewhere in Europe
            double spentMoney = budget * 0.90;
            System.out.printf("%s%n", europe);
            System.out.printf("%s - %.2f", hotel, spentMoney);
        }
    }
}
