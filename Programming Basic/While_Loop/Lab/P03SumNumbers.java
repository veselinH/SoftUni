package While_Loop.Lab;

import java.util.Scanner;

public class P03SumNumbers {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int sumNumbers = 0;

        while (!(sumNumbers >= number)) {
            int enteredNumber = Integer.parseInt(scanner.nextLine());
            sumNumbers += enteredNumber;
        }
        System.out.println(sumNumbers);

    }
}
