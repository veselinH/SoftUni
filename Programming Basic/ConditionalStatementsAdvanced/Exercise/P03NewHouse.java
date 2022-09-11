package ConditionalStatementsAdvanced.Exercise;

import java.util.Scanner;

public class P03NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String flowersType = scanner.nextLine();
        int flowersCount = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double rosePrice = 5 * flowersCount;
        double dahliaPrice = 3.80 * flowersCount;
        double tulipPrice = 2.80 * flowersCount;
        double narcissusPrice = 3 * flowersCount;
        double gladiolusPrice = 2.50 * flowersCount;

        if (flowersCount > 80) {
            rosePrice *= 0.90;
            tulipPrice *= 0.85;
        }
        if (flowersCount > 90) {
            dahliaPrice *= 0.85;
        }
        if (flowersCount < 120) {
            narcissusPrice *= 1.15;
        }
        if (flowersCount < 80) {
            gladiolusPrice *= 1.20;
        }

        switch (flowersType) {
            case "Roses":
                if (budget >= rosePrice) {
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",
                            flowersCount, flowersType, (budget - rosePrice));
                } else {
                    System.out.printf("Not enough money, you need %.2f leva more.",
                            (rosePrice - budget));
                }
                break;
            case "Dahlias":
                if (budget >= dahliaPrice) {
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",
                            flowersCount, flowersType, (budget - dahliaPrice));
                } else {
                    System.out.printf("Not enough money, you need %.2f leva more.",
                            (dahliaPrice - budget));
                }
                break;
            case "Tulips":
                if (budget >= tulipPrice) {
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",
                            flowersCount, flowersType, (budget - tulipPrice));
                } else {
                    System.out.printf("Not enough money, you need %.2f leva more.",
                            (tulipPrice - budget));
                }
                break;
            case "Narcissus":
                if (budget >= narcissusPrice) {
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",
                            flowersCount, flowersType, (budget - narcissusPrice));
                } else {
                    System.out.printf("Not enough money, you need %.2f leva more.",
                            (narcissusPrice - budget));
                }
                break;
            case "Gladiolus":
                if (budget >= gladiolusPrice) {
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",
                            flowersCount, flowersType, (budget - gladiolusPrice));
                } else {
                    System.out.printf("Not enough money, you need %.2f leva more.",
                            (gladiolusPrice - budget));
                }
                break;
        }
    }
}
