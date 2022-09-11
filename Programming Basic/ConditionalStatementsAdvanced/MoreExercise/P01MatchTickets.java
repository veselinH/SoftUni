package ConditionalStatementsAdvanced.MoreExercise;

import java.util.Scanner;

public class P01MatchTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String ticketType = scanner.nextLine();
        int peopleInGroup = Integer.parseInt(scanner.nextLine());

        double budgetLeft = 0.00;
        double vipTicket = 499.99 * peopleInGroup;
        double normalTicket = 249.99 * peopleInGroup;

        if (peopleInGroup >= 1 && peopleInGroup <= 4) {
            budgetLeft = budget * 0.25;
        } else if (peopleInGroup <= 9) {
            budgetLeft = budget * 0.40;
        } else if (peopleInGroup <= 24) {
            budgetLeft = budget * 0.50;
        } else if (peopleInGroup <= 49) {
            budgetLeft = budget * 0.60;
        } else {
            budgetLeft = budget * 0.75;
        }

        double diffVip = Math.abs(budgetLeft - vipTicket);
        double diffNormal = Math.abs(budgetLeft - normalTicket);

        switch (ticketType) {
            case "VIP":
                if (vipTicket <= budgetLeft) {
                    System.out.printf("Yes! You have %.2f leva left.", diffVip);
                } else {
                    System.out.printf("Not enough money! You need %.2f leva.", diffVip);
                }
                break;
            case "Normal":
                if (normalTicket <= budgetLeft) {
                    System.out.printf("Yes! You have %.2f leva left.", diffNormal);
                } else {
                    System.out.printf("Not enough money! You need %.2f leva.", diffNormal);
                }
                break;


        }
    }
}
