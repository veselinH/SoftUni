package ConditionalStatements.MoreExercise;

import java.util.Scanner;

public class FuelTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Прочитаме входа
        // два реда – текст и реално число
        // "Diesel", "Gasoline" или "Gas"

        String fuelType = scanner.nextLine();                  // вида гориво
        double fuel = Double.parseDouble(scanner.nextLine());  // наличните литри гориво в резервоара

        // Изчисляваме
        String Diesel = "diesel";     // Защото от задачата изискват
        String Gasoline = "gasoline"; // Input с голяма буква
        String Gas = "gas";           // Output с малка

            /* Ако литрите гориво са повече или равни на 25, на конзолата да се отпечата
            "You have enough {вида на горивото}.", */

        if (fuel >= 25 & fuelType.equals("Diesel")) {
            System.out.printf("You have enough %s.", Diesel);
        } else if (fuel >= 25 & fuelType.equals("Gasoline")) {
            System.out.printf("You have enough %s.", Gasoline);
        } else if (fuel >= 25 & fuelType.equals("Gas")) {
            System.out.printf("You have enough %s.", Gas);
        }
        //Ако са по-малко от 25, да се отпечата "Fill your tank with {вида на горивото}!".
        else if (fuel < 25 & fuelType.equals("Diesel")) {
            System.out.printf("Fill your tank with %s!", Diesel);
        } else if (fuel < 25 & fuelType.equals("Gasoline")) {
            System.out.printf("Fill your tank with %s!", Gasoline);
        } else if (fuel < 25 & fuelType.equals("Gas")) {
            System.out.printf("Fill your tank with %s!", Gas);
        } else {
            System.out.println("Invalid fuel!");


        }
    }
}