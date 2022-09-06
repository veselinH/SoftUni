package ConditionalStatements.MoreExercise;

import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Прочитаме входа

        int n = Integer.parseInt(scanner.nextLine()); // брой километри
        String time = scanner.nextLine(); // ден или нощ

        double taxiPriceDay = 0.79 * n + 0.70;   // цена през деня с такси
        double taxiPriceNight = 0.90 * n + 0.70; // цена през ноща с такси
        double busPrice = 0.09 * n;              // цена през деня и ноща с автобус(само n > 20)
        double trainPrice = 0.06 * n;            // цена през дена и ноща с влак(само n > 100)

        if (n < 20) {
            if (time.equals("day")) {
                System.out.printf("%.2f", taxiPriceDay);
            } else {
                System.out.printf("%.2f", taxiPriceNight);
            }
        } else if (n < 100) {
            System.out.printf("%.2f", busPrice);
        } else {
            System.out.printf("%.2f", trainPrice);
        }

    }

}


