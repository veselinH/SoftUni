package ConditionalStatements.MoreExercise;

import java.util.Scanner;

public class FuelTankV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Прочитаме входа

        String fuelType = scanner.nextLine(); // – текст с възможности: "Gas", "Gasoline" или "Diesel"
        double fuelLitres = Double.parseDouble(scanner.nextLine());
        String clubCard = scanner.nextLine();

        // Цени на горивата

        double gasolineCost = fuelLitres * 2.22;
        double dieselCost = fuelLitres * 2.33;
        double gasCost = fuelLitres * 0.93;

        // Изчисляваме цената ако има карта за отстъпки
        //Ако водача има карта за отстъпки,  той се възползва от следните намаления за литър гориво:
        // 18 ст. за литър бензин
        // 12 ст. за литър дизел
        // 8 ст. за литър газ.

        if (clubCard.equals("Yes")) {
            gasolineCost = fuelLitres * (2.22 - 0.18);
            dieselCost = fuelLitres * (2.33 - 0.12);
            gasCost = fuelLitres * (0.93 - 0.08);
        }


        // Изчисляваме с отстъпката за литри
        //Ако шофьора е заредил между 20 и 25 литра включително, той получава 8 процента отстъпка от крайната цена.
        if (fuelLitres >= 20 & fuelLitres <= 25) {
            gasolineCost *= 0.92;
            dieselCost *= 0.92;
            gasCost *= 0.92;
        }
        //При повече от 25 литра гориво, той получава 10 процента отстъпка от крайната цена.
        else if (fuelLitres > 25) {
            gasolineCost *= 0.90;
            dieselCost *= 0.90;
            gasCost *= 0.90;
        }

        // Изчисляваме цената за всяко гориво

        if (fuelType.equals("Gasoline")) {
            System.out.printf("%.2f lv.", gasolineCost);
        } else if (fuelType.equals("Diesel")) {
            System.out.printf("%.2f lv.", dieselCost);
        } else if (fuelType.equals("Gas")) {
            System.out.printf("%.2f lv.", gasCost);
        }


    }
}
