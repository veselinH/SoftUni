package ConditionalStatementsAdvanced.Lab;

import java.util.Scanner;

public class P05SmallShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        String city = scanner.nextLine();
        double count = Double.parseDouble(scanner.nextLine());

        if (city.equals("Sofia")) {
            if (product.equals("coffee")) {
                System.out.println(count * 0.50);
            } else if (product.equals("water")) {
                System.out.println(count * 0.80);
            } else if (product.equals("beer")) {
                System.out.println(count * 1.20);
            } else if (product.equals("sweets")) {
                System.out.println(count * 1.45);
            } else if (product.equals("peanuts")) {
                System.out.println(count * 1.60);
            }
        } else if (city.equals("Plovdiv")) {
            if (product.equals("coffee")) {
                System.out.println(count * 0.40);
            } else if (product.equals("water")) {
                System.out.println(count * 0.70);
            } else if (product.equals("beer")) {
                System.out.println(count * 1.15);
            } else if (product.equals("sweets")) {
                System.out.println(count * 1.30);
            } else if (product.equals("peanuts")) {
                System.out.println(count * 1.50);
            }
        } else {
            if (product.equals("coffee")) {
                System.out.println(count * 0.45);
            } else if (product.equals("water")) {
                System.out.println(count * 0.70);
            } else if (product.equals("beer")) {
                System.out.println(count * 1.10);
            } else if (product.equals("sweets")) {
                System.out.println(count * 1.35);
            } else if (product.equals("peanuts")) {
                System.out.println(count * 1.55);
            }
        }
    }
}
