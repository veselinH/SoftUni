package ConditionalStatements.Exercise;

import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double tripPrice = Double.parseDouble(scanner.nextLine());
        int puzzles = Integer.parseInt(scanner.nextLine());
        int talkingDolls = Integer.parseInt(scanner.nextLine());
        int teddyBears = Integer.parseInt(scanner.nextLine());
        int minions = Integer.parseInt(scanner.nextLine());
        int trucks = Integer.parseInt(scanner.nextLine());


        double sum = (puzzles * 2.6) +
                (talkingDolls * 3) +
                (teddyBears * 4.10) +
                (minions * 8.20) +
                (trucks * 2);
        int countAllToys = puzzles + talkingDolls + teddyBears + minions + trucks;

        if (countAllToys >= 50) {
            sum = sum * 0.75;
        }

        sum = sum * 0.90;

        double diff = Math.abs(sum - tripPrice);

        if (sum >= tripPrice) {
            System.out.printf("Yes! %.2f lv left.", diff);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.", diff);

        }


    }


}

