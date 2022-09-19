package For_Loop.MoreExercises;

import java.util.Scanner;

public class P06Bills {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int months = Integer.parseInt(scanner.nextLine());

        int waterBill = 20;
        int internetBill = 15;
        double electricityBillTotal = 0;
        double otherBills = 0;
        double waterBillsTotal = 0;
        double internetBillsTotal = 0;

        for (int i = 0; i < months; i++) {
            double electricityBill = Double.parseDouble(scanner.nextLine());
            waterBillsTotal += waterBill;
            internetBillsTotal += internetBill;
            electricityBillTotal += electricityBill;
            otherBills += (waterBill + internetBill + electricityBill) * 1.20;

        }
        double averageBills = (waterBillsTotal + internetBillsTotal + electricityBillTotal + otherBills) / months;

        System.out.printf("Electricity: %.2f lv\n", electricityBillTotal);
        System.out.printf("Water: %.2f lv\n", waterBillsTotal);
        System.out.printf("Internet: %.2f lv\n", internetBillsTotal);
        System.out.printf("Other: %.2f lv\n", otherBills);
        System.out.printf("Average: %.2f lv", averageBills);
    }
}
