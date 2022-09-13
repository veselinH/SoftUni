package For_Loop.Exercise;

import java.util.Scanner;

public class P04CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lilyAge = Integer.parseInt(scanner.nextLine());
        double laundryMachinePrice = Double.parseDouble(scanner.nextLine());
        int toyPrice = Integer.parseInt(scanner.nextLine());

        int savedMoney1 = 0;
        int money = 10;
        int toysIncome = 0;

        for (int i = 1; i <= lilyAge; i++) {
            if (i % 2 == 0) {
                savedMoney1 += money;
                money += 10;
                savedMoney1 -= 1;

            } else {
                toysIncome += toyPrice;
            }

        }

        double totalSavedMoney = savedMoney1 + toysIncome;
        double diff = Math.abs(totalSavedMoney - laundryMachinePrice);

        if (totalSavedMoney >= laundryMachinePrice){
            System.out.printf("Yes! %.2f", diff);
        } else {
            System.out.printf("No! %.2f", diff);
        }
    }
}
