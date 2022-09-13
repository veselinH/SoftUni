package For_Loop.Exercise;

import java.util.Scanner;

public class P02HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int maxValue = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            sum += number;
            if (number > maxValue) {
                maxValue = number;

            }
        }
        sum -= maxValue;

        if (maxValue == sum) {
            System.out.printf("Yes%nSum = %d", maxValue);
        } else {
            System.out.printf("No%nDiff = %d", Math.abs(sum - maxValue));
        }


    }
}
