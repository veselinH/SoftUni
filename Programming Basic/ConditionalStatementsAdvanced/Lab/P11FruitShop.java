package ConditionalStatementsAdvanced.Lab;

import java.util.Scanner;

public class P11FruitShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        double fruitPrice = 0;
        boolean isValid = fruit.equals("banana") || fruit.equals("apple") || fruit.equals("orange") || fruit.equals("grapefruit") || fruit.equals("kiwi") || fruit.equals("pineapple") || fruit.equals("grapes");
        boolean isValid2 = (dayOfWeek.equals("Monday") || dayOfWeek.equals("Thursday") || dayOfWeek.equals("Wednesday") || dayOfWeek.equals("Tuesday") || dayOfWeek.equals("Friday")) || (dayOfWeek.equals("Saturday") || dayOfWeek.equals("Sunday"));

        if (!isValid || !isValid2) {
            System.out.println("error");
        } else if (dayOfWeek.equals("Monday") || dayOfWeek.equals("Thursday") || dayOfWeek.equals("Wednesday") || dayOfWeek.equals("Tuesday") || dayOfWeek.equals("Friday")) {
            if (fruit.equals("banana")) {
                fruitPrice = 2.50;

            } else if (fruit.equals("apple")) {
                fruitPrice = 1.20;
            } else if (fruit.equals("orange")) {
                fruitPrice = 0.85;
            } else if (fruit.equals("grapefruit")) {
                fruitPrice = 1.45;
            } else if (fruit.equals("kiwi")) {
                fruitPrice = 2.70;
            } else if (fruit.equals("pineapple")) {
                fruitPrice = 5.50;
            } else if (fruit.equals("grapes")) {
                fruitPrice = 3.85;
            }
            double result = fruitPrice * quantity;
            System.out.printf("%.2f", result);
        } else if (dayOfWeek.equals("Saturday") || dayOfWeek.equals("Sunday")) {

            if (fruit.equals("banana")) {
                fruitPrice = 2.70;
            } else if (fruit.equals("apple")) {
                fruitPrice = 1.25;
            } else if (fruit.equals("orange")) {
                fruitPrice = 0.90;
            } else if (fruit.equals("grapefruit")) {
                fruitPrice = 1.60;
            } else if (fruit.equals("kiwi")) {
                fruitPrice = 3.00;
            } else if (fruit.equals("pineapple")) {
                fruitPrice = 5.60;
            } else if (fruit.equals("grapes")) {
                fruitPrice = 4.20;
            }
            double result = fruitPrice * quantity;
            System.out.printf("%.2f", result);


        }
    }
}
