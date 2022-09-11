package ConditionalStatementsAdvanced.Exercise;

import java.util.Scanner;

public class P07HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int nights = Integer.parseInt(scanner.nextLine());
        double studioCost = 0.0;
        double apartmentCost = 0.0;

        switch (month) {
            case "May":
            case "October":
                studioCost = 50;
                apartmentCost = 65;

                if (nights > 7 && nights <= 14) {
                    studioCost *= 0.95;
                } else if (nights > 14) {
                    studioCost *= 0.70;
                    apartmentCost *= 0.90;
                }
                break;
            case "June":
            case "September":
                studioCost = 75.20;
                apartmentCost = 68.70;
                if (nights > 14) {
                    studioCost *= 0.80;
                    apartmentCost *= 0.90;
                }
                break;
            case "July":
            case "August":
                studioCost = 76;
                apartmentCost = 77;
                if (nights > 14) {
                    apartmentCost *= 0.90;
                }
                break;
        }
        double totalStudioCost = nights * studioCost;
        double totalApartmentCost = nights * apartmentCost;
        System.out.printf("Apartment: %.2f lv.%n", totalApartmentCost);
        System.out.printf("Studio: %.2f lv.", totalStudioCost);
    }
}
