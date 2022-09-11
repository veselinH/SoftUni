package ConditionalStatementsAdvanced.Exercise;

import java.util.Scanner;

public class P04FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fishermen = Integer.parseInt(scanner.nextLine());

        double boatRent = 0.0;

        switch (season) {
            case "Spring":
                boatRent = 3000;
                break;

            case "Summer":
            case "Autumn":
                boatRent = 4200;
                break;

            case "Winter":
                boatRent = 2600;
                break;
        }
        if (fishermen <= 6) {
            boatRent *= 0.90;
        } else if (fishermen <= 11) {
            boatRent *= 0.85;
        } else {
            boatRent *= 0.75;
        }
        if (fishermen % 2 == 0 && !season.equals("Autumn")) {
            boatRent *= 0.95;
        }
        double diff = Math.abs(budget - boatRent);

        if (budget >= boatRent) {
            System.out.printf("Yes! You have %.2f leva left.", diff);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", diff);
        }
    }
}
