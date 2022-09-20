package While_Loop.Exercise;

import java.util.Scanner;

public class P03VacationV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double vocationCost = Double.parseDouble(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());

        String input = scanner.nextLine();
        int spendCount = 0;
        int days = 0;
        boolean canSave = true;

        while (budget < vocationCost) {
            double money = Double.parseDouble(scanner.nextLine());
            switch (input) {
                case "spend":
                    budget -= money;
                    spendCount++;
                    days++;
                    if (budget < 0) {
                        budget = 0;
                    }
                    break;
                case "save":
                    budget += money;
                    spendCount = 0;
                    days++;
                    break;
            }
            if (spendCount == 5) {
                canSave = false;

                break;
            }
            if (budget >= vocationCost) {
                break;
            }
            input = scanner.nextLine();
        }
        if (!canSave) {
            System.out.println("You can't save the money.");
            System.out.printf("%d", days);
        } else {
            System.out.printf("You saved the money for %d days.", days);
        }
    }
}
