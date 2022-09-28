package While_Loop.MoreExercises;

import java.util.Scanner;

public class P05AverageNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbersCount = Integer.parseInt(scanner.nextLine());
        double sumNumbers = 0;
        for (int i = 0; i < numbersCount; i++) {
            double number = Double.parseDouble(scanner.nextLine());
            sumNumbers += number;

        }
        System.out.printf("%.2f", sumNumbers / numbersCount);

    }


}
