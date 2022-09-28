package While_Loop.MoreExercises;

import java.util.Scanner;

public class P01Dishwasher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int detergent = Integer.parseInt(scanner.nextLine());

        int detergentTotalMl = 750 * detergent;
        int dishMl = 5;
        int potMl = 15;
        boolean notEnough = false;
        int washedDishes = 0;
        int washedPots = 0;

        int loadingCount = 1;

        String input = scanner.nextLine();


        while (!input.equals("End")) {
            int bottlesCount = Integer.parseInt(input);
            if (loadingCount % 3 == 0) {
                detergentTotalMl -= potMl * bottlesCount;
                washedPots += bottlesCount;
                loadingCount++;
            } else {
                loadingCount++;
                washedDishes += bottlesCount;
                detergentTotalMl -= bottlesCount * dishMl;
            }
            if (detergentTotalMl < 0) {
                notEnough = true;
                break;
            }


            input = scanner.nextLine();
        }
        double diff = Math.abs(detergentTotalMl);

        if (notEnough) {
            System.out.printf("Not enough detergent, %.0f ml. more necessary!\n", diff);
        } else {
            System.out.printf("Detergent was enough!\n" +
                    "%d dishes and %d pots were washed.\n" +
                    "Leftover detergent %d ml.\n", washedDishes, washedPots, detergentTotalMl);
        }
    }
}
