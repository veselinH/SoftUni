package For_Loop.MoreExercises;

import java.util.Scanner;

public class P08EqualPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int equals = Integer.parseInt(scanner.nextLine());
        int totalSumOfPairs = 0;
        int maxNumber = Integer.MIN_VALUE;
        int minNumber = Integer.MAX_VALUE;
        boolean isValid = false;

        for (int i = 0; i < equals; i++) {
            int firstNum = Integer.parseInt(scanner.nextLine());
            int secondNum = Integer.parseInt(scanner.nextLine());
            totalSumOfPairs += firstNum + secondNum;
            if (maxNumber < (firstNum + secondNum)) {
                maxNumber = firstNum + secondNum;
            }
            if (minNumber > (firstNum + secondNum)) {
                minNumber = firstNum + secondNum;
            }
        }
        if (maxNumber == minNumber) {
            isValid = true;
        }
        double diff = Math.abs(maxNumber - minNumber);
        if (isValid) {
            System.out.printf("Yes, value=%d", totalSumOfPairs / equals);
        } else {
            System.out.printf("No, maxdiff=%.0f", diff);
        }
    }
}
