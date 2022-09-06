package FirstStepsInCoding.Exercise;

import java.util.Scanner;

public class FoodDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int chickenMenuCount = Integer.parseInt(scanner.nextLine());
        int fishMenuCount = Integer.parseInt(scanner.nextLine());
        int veganMenuCount = Integer.parseInt(scanner.nextLine());

        double chickenMenuPrice = 10.35;
        double fishMenuPrice = 12.40;
        double veganMenuPrice = 8.15;

        double chickenMenuCost = chickenMenuCount * chickenMenuPrice;
        double fishMenuCost = fishMenuCount * fishMenuPrice;
        double veganMenuCost = veganMenuCount * veganMenuPrice;

        double totalMenusCost = chickenMenuCost + fishMenuCost + veganMenuCost;

        double desertCost = totalMenusCost * (20.0 / 100);
        double deliveryCost = 2.50;

        double orderCost = totalMenusCost + desertCost + deliveryCost;

        System.out.println(orderCost);


    }
}
