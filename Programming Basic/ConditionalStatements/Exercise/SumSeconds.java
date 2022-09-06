package ConditionalStatements.Exercise;

import java.util.Scanner;

public class SumSeconds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());

        int timeInSeconds = first + second + third;

        int timeInMinutes = timeInSeconds / 60;
        int seconds = timeInSeconds % 60;

        if (seconds < 10){
            System.out.printf("%d:0%d", timeInMinutes, seconds);
        }else {
            System.out.printf("%d:%d", timeInMinutes, seconds);
        }



    }

}
