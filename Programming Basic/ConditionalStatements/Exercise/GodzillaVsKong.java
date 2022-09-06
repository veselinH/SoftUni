package ConditionalStatements.Exercise;

import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int statisticians = Integer.parseInt(scanner.nextLine());
        double outfitPerStatistician = Double.parseDouble(scanner.nextLine());

        double decor = budget * 0.10;

        if (statisticians > 150) {
            outfitPerStatistician = outfitPerStatistician * 0.90;
        }
        double movieSum = (outfitPerStatistician * statisticians) + decor;
        double diff = Math.abs(movieSum - budget);

        boolean isValid = movieSum > budget;
        boolean noValid = budget >= movieSum;
        if (isValid) {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", diff);
        } else if (noValid) {

            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", diff);

        }
    }
}
