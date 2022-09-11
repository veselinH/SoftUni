package ConditionalStatementsAdvanced.MoreExercise;

import java.util.Scanner;

public class P05Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String placeType = "";
        String city = "";
        double vacationPrice = 0.00;

        switch (season) {
            case "Summer":
                city = "Alaska";
                if (budget <= 1000) {
                    placeType = "Camp";
                    vacationPrice = budget * 0.65;
                } else if (budget <= 3000) {
                    placeType = "Hut";
                    vacationPrice = budget * 0.80;
                } else {
                    placeType = "Hotel";
                    vacationPrice = budget * 0.90;
                }
                break;
            case "Winter":
                city = "Morocco";
                if (budget <= 1000) {
                    placeType = "Camp";
                    vacationPrice = budget * 0.45;
                } else if (budget <= 3000) {
                    placeType = "Hut";
                    vacationPrice = budget * 0.60;
                } else {
                    placeType = "Hotel";
                    vacationPrice = budget * 0.90;
                }
                break;
        }
        System.out.printf("%s - %s - %.2f", city, placeType, vacationPrice);
    }
}
