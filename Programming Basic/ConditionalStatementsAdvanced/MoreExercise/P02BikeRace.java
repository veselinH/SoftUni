package ConditionalStatementsAdvanced.MoreExercise;

import java.util.Scanner;

public class P02BikeRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int juniors = Integer.parseInt(scanner.nextLine());
        int seniors = Integer.parseInt(scanner.nextLine());
        String trackType = scanner.nextLine();

        double donatedSum = 0.00;


        switch (trackType) {
            case "trail":
                donatedSum = ((juniors * 5.50) + (seniors * 7)) * 0.95;
                break;
            case "cross-country":
                if ((juniors + seniors) >= 50) {
                    donatedSum = (((juniors * 8) + (seniors * 9.50)) * 0.75) * 0.95;
                } else {
                    donatedSum = ((juniors * 8) + (seniors * 9.50)) * 0.95;
                }
                break;
            case "downhill":
                donatedSum = ((juniors * 12.25) + (seniors * 13.75)) * 0.95;
                break;
            case "road":
                donatedSum = ((juniors * 20) + (seniors * 21.50)) * 0.95;
                break;
        }
        System.out.printf("%.2f", donatedSum);
    }
}
