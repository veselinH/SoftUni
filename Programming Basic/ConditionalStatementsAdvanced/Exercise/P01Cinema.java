package ConditionalStatementsAdvanced.Exercise;

import java.util.Scanner;

public class P01Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String projection = scanner.nextLine();
        int rolls = Integer.parseInt(scanner.nextLine());
        int colonies = Integer.parseInt(scanner.nextLine());

        int totalSeats = rolls * colonies;
        double income = 0;

        switch (projection) {
            case "Premiere":
                income = totalSeats * 12.00;
                break;
            case "Normal":
                income = totalSeats * 7.50;
                break;
            case "Discount":
                income = totalSeats * 5.00;
                break;

        }
        System.out.printf("%.2f leva", income);
    }

}
