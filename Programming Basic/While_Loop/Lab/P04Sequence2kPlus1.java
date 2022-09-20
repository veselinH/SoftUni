package While_Loop.Lab;

import java.util.Scanner;

public class P04Sequence2kPlus1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Напишете програма, която чете число n, въведено от потребителя, и отпечатва всички числа ≤ n от редицата:
        //1, 3, 7, 15, 31, …. Всяко следващо число се изчислява като умножим предишното с 2 и добавим 1.

        int n = Integer.parseInt(scanner.nextLine());
        int number = 1;

        while (number <= n) {
            System.out.println(number);
            number = number * 2 + 1;
        }
        //int number = Integer.parseInt(scanner.nextLine());
        //
        //
        //        for (int i = 1; i <= number; i = i * 2 + 1) {
        //            System.out.println(i);
        //
        //        }
    }
}
