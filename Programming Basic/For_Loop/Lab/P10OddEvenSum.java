package For_Loop.Lab;

import java.util.Scanner;

public class P10OddEvenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int sumEven = 0;
        int sumOdd = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (i % 2 == 0) {
                sumEven += number;
            } else {
                sumOdd += number;
            }
        }
        if (sumEven == sumOdd) {
            System.out.printf("Yes%n");
            System.out.printf("Sum = %d", sumEven);
        } else {
            System.out.printf("No%n");
            System.out.printf("Diff = %d", Math.abs(sumEven - sumOdd));
        }

    }
}
