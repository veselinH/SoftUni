package ConditionalStatements.Exercise;

import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Прочитаме вход
        // 1. Бюджетът на Петър - реално число в интервала [0.0…100000.0]
        //2. Броят видеокарти - цяло число в интервала [0…100]
        //3. Броят процесори - цяло число в интервала [0…100]
        //4. Броят рам памет - цяло число в интервала [0…100]

        double budget = Double.parseDouble(scanner.nextLine());
        int videoCards = Integer.parseInt(scanner.nextLine());
        int processors = Integer.parseInt(scanner.nextLine());
        int ramMemory = Integer.parseInt(scanner.nextLine());

        //Изчисляваме цените и програмираме

        double videoCardsPrice = videoCards * 250;

        // Изчисляваме отстъпката

        if (videoCards > processors) {
            videoCardsPrice = videoCardsPrice * 0.85;
        }

        double processorsPrice = videoCardsPrice * 0.35 * processors;
        double ramMemoryPrice = videoCardsPrice * 0.10 * ramMemory;

        double totalPrice = videoCardsPrice + processorsPrice + ramMemoryPrice;
        double diff = Math.abs(budget - totalPrice);

        if (budget >= totalPrice) {
            System.out.printf("You have %.2f leva left!", diff);
        } else {
            System.out.printf("Not enough money! You need %.2f leva more!", diff);
        }


    }
}
