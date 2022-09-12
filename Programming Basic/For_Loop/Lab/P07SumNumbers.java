package For_Loop.Lab;

import java.util.Scanner;

public class P07SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersCount = Integer.parseInt(scanner.nextLine());

        int sum = 0;

        for (int i = 1; i <= numbersCount; i++) {
            int numberOne = Integer.parseInt(scanner.nextLine());
            sum += numberOne;
        }
        System.out.println(sum);

    }
}
