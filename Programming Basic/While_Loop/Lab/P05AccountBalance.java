package While_Loop.Lab;

import java.util.Scanner;

public class P05AccountBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalMoney = 0.00;

        while (!input.equals("NoMoreMoney")){
            double number = Double.parseDouble(input);
            if (number < 0){
                System.out.println("Invalid operation!");
                break;
            }
            totalMoney += number;
            System.out.printf("Increase: %.2f\n", number);
            input = scanner.nextLine();
        }
        System.out.printf("Total: %.2f", totalMoney);
    }
}
