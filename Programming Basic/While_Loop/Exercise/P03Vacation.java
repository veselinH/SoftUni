package While_Loop.Exercise;

import java.util.Scanner;

public class P03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int vacationCost = Integer.parseInt(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());

        int spendCount = 0;
        int days = 0;
        boolean canSave = true;
        String input = scanner.nextLine();

        while (budget < vacationCost) {
            days++;
            if (input.equals("spend")) {
                double money = Double.parseDouble(scanner.nextLine());
                budget -= money;
                if (budget < 0) {
                    budget = 0;
                }
                if (spendCount == 5) {
                    canSave = false;
                    break;
                }
                spendCount++;
            } else if (input.equals("save")) {
                double money = Double.parseDouble(scanner.nextLine());
                budget += money;
                spendCount--;
            }
            input = scanner.nextLine();
        }
        if (canSave) {
            System.out.printf("You saved the money for %d days.", days);
        } else {
            System.out.println("You can't save the money.");
            System.out.printf("%d", days);
        }

    }
}
