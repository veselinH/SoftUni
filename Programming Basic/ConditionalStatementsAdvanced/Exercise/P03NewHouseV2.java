package ConditionalStatementsAdvanced.Exercise;

import java.util.Scanner;

public class P03NewHouseV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String flowerType = scanner.nextLine();
        int flowersCount = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        switch (flowerType) {
            case "Roses":
                double rosesPrice = 5 * flowersCount; // 5лв. цена на една роза
                if (flowersCount > 80) {
                    rosesPrice *= 0.90;
                }
                double diffRoses = Math.abs(budget - rosesPrice);
                if (budget >= rosesPrice) {
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowersCount, flowerType, diffRoses);
                } else {
                    System.out.printf("Not enough money, you need %.2f leva more.", diffRoses);
                }
                break;
            case "Dahlias":
                double dahliasPrice = flowersCount * 3.80; // 3.80лв цена на брой далия
                if (flowersCount > 90) {
                    dahliasPrice *= 0.85;
                }
                double diffDahlias = Math.abs(budget - dahliasPrice);
                if (budget >= dahliasPrice) {
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowersCount, flowerType, diffDahlias);
                } else {
                    System.out.printf("Not enough money, you need %.2f leva more.", diffDahlias);
                }
                break;
            case "Tulips":
                double tulipsPrice = 2.80 * flowersCount; // 2.80лв. цена на бройка лале
                if (flowersCount > 80) {
                    tulipsPrice *= 0.85;
                }
                double diffTulips = Math.abs(budget - tulipsPrice);
                if (budget >= tulipsPrice) {
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowersCount, flowerType, diffTulips);
                } else {
                    System.out.printf("Not enough money, you need %.2f leva more.", diffTulips);
                }
                break;
            case "Narcissus":
                double narcissusPrice = 3 * flowersCount; // 3лв. цена на бройка нарцис
                if (flowersCount < 120) {
                    narcissusPrice *= 1.15;
                }
                double diffNarcissus = Math.abs(budget - narcissusPrice);
                if (budget >= narcissusPrice) {
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowersCount, flowerType, diffNarcissus);
                } else {
                    System.out.printf("Not enough money, you need %.2f leva more.", diffNarcissus);
                }
                break;
            case "Gladiolus":
                double gladiolusPrice = 2.50 * flowersCount; // 2.50лв. цена на бройка гладиола
                if (flowersCount < 80) {
                    gladiolusPrice *= 1.20;
                }
                double diffGladiolus = Math.abs(budget - gladiolusPrice);
                if (budget >= gladiolusPrice) {
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowersCount, flowerType, diffGladiolus);
                } else {
                    System.out.printf("Not enough money, you need %.2f leva more.", diffGladiolus);
                }
                break;
        }
    }
}
