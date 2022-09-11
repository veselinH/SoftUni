package ConditionalStatementsAdvanced.MoreExercise;

import java.util.Scanner;

public class P04CarToGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String classType = "";
        String carType = "";
        double carPrice = 0.00;


        switch (season) {
            case "Summer":
                if (budget <= 100) {
                    classType = "Economy class";
                    carType = "Cabrio";
                    carPrice = budget * 0.35;
                } else if (budget <= 500) {
                    classType = "Compact class";
                    carType = "Cabrio";
                    carPrice = budget * 0.45;
                } else {
                    classType = "Luxury class";
                    carType = "Jeep";
                    carPrice = budget * 0.90;
                }
                break;
            case "Winter":
                if (budget <= 100) {
                    classType = "Economy class";
                    carType = "Jeep";
                    carPrice = budget * 0.65;
                } else if (budget <= 500) {
                    classType = "Compact class";
                    carType = "Jeep";
                    carPrice = budget * 0.80;
                } else {
                    classType = "Luxury class";
                    carType = "Jeep";
                    carPrice = budget * 0.90;
                }
                break;
        }
        System.out.printf("%s%n", classType);
        System.out.printf("%s - %.2f", carType, carPrice);

    }
}
