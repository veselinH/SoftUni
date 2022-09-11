package ConditionalStatementsAdvanced.MoreExercise;

import java.util.Scanner;

public class P03Flowers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int chrysanthemums = Integer.parseInt(scanner.nextLine());
        int roses = Integer.parseInt(scanner.nextLine());
        int tulips = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        String isHoliday = scanner.nextLine();

        double chrysanthemumsPrice = 0.00;
        double rosesPrice = 0.00;
        double tulipsPrice = 0.00;
        double bouquetPrice = 0.00;

        switch (season) {
            case "Spring":
                chrysanthemumsPrice = chrysanthemums * 2;
                rosesPrice = roses * 4.10;
                tulipsPrice = tulips * 2.50;

                if (isHoliday.equals("Y")) {
                    chrysanthemumsPrice *= 1.15;
                    rosesPrice *= 1.15;
                    tulipsPrice *= 1.15;
                }
                bouquetPrice = chrysanthemumsPrice + rosesPrice + tulipsPrice;
                if (tulips > 7) {
                    bouquetPrice *= 0.95;
                }
                if ((roses + chrysanthemums + tulips) > 20) {
                    bouquetPrice *= 0.80;
                }
                bouquetPrice += 2;

                break;
            case "Summer":
                chrysanthemumsPrice = chrysanthemums * 2;
                rosesPrice = roses * 4.10;
                tulipsPrice = tulips * 2.50;

                if (isHoliday.equals("Y")) {
                    chrysanthemumsPrice *= 1.15;
                    rosesPrice *= 1.15;
                    tulipsPrice *= 1.15;
                }
                bouquetPrice = chrysanthemumsPrice + rosesPrice + tulipsPrice;
                if ((roses + chrysanthemums + tulips) > 20) {
                    bouquetPrice *= 0.80;
                }

                bouquetPrice += 2;

                break;
            case "Autumn":
                chrysanthemumsPrice = chrysanthemums * 3.75;
                rosesPrice = roses * 4.50;
                tulipsPrice = tulips * 4.15;

                if (isHoliday.equals("Y")) {
                    chrysanthemumsPrice *= 1.15;
                    rosesPrice *= 1.15;
                    tulipsPrice *= 1.15;
                }
                bouquetPrice = chrysanthemumsPrice + rosesPrice + tulipsPrice;

                if ((roses + chrysanthemums + tulips) > 20) {
                    bouquetPrice *= 0.80;
                }

                bouquetPrice += 2;

                break;
            case "Winter":
                chrysanthemumsPrice = chrysanthemums * 3.75;
                rosesPrice = roses * 4.50;
                tulipsPrice = tulips * 4.15;

                if (isHoliday.equals("Y")) {
                    chrysanthemumsPrice *= 1.15;
                    rosesPrice *= 1.15;
                    tulipsPrice *= 1.15;
                }

                bouquetPrice = chrysanthemumsPrice + rosesPrice + tulipsPrice;

                if (roses >= 10) {
                    bouquetPrice *= 0.90;
                }

                if ((roses + chrysanthemums + tulips) > 20) {
                    bouquetPrice *= 0.80;
                }

                bouquetPrice += 2;

                break;

        }
        System.out.printf("%.2f", bouquetPrice);


    }
}
