package While_Loop.MoreExercises;

import java.util.Scanner;

public class P02ReportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fundNeeded = Integer.parseInt(scanner.nextLine());

        int payment = 1;
        double cashPaymentAmount = 0;
        double cardPaymentAmount = 0;
        int cashPaymentCount = 0;
        int cardPaymentCount = 0;
        boolean isCollected = false;
        double fundsCollected = 0;

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            double funds = Double.parseDouble(input);

            if (payment % 2 == 0) {
                if (funds < 10) {
                    System.out.println("Error in transaction!");
                    payment++;
                } else {
                    System.out.println("Product sold!");
                    cardPaymentCount++;
                    payment++;
                    cardPaymentAmount += funds;
                }
            } else {
                if (funds > 100) {
                    System.out.println("Error in transaction!");
                    payment++;
                } else {
                    System.out.println("Product sold!");
                    cashPaymentCount++;
                    payment++;
                    cashPaymentAmount += funds;
                }
            }
            fundsCollected = cashPaymentAmount + cardPaymentAmount;
            if (fundsCollected >= fundNeeded) {
                isCollected = true;
                break;
            }


            input = scanner.nextLine();
        }
        if (isCollected) {
            System.out.printf("Average CS: %.2f\n" +
                    "Average CC: %.2f\n", cashPaymentAmount / cashPaymentCount, cardPaymentAmount / cardPaymentCount);
        } else {
            System.out.println("Failed to collect required money for charity.");
        }
    }
}
