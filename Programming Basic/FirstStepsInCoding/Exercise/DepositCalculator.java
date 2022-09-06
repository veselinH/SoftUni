package FirstStepsInCoding.Exercise;

import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double depositSum = Double.parseDouble(scanner.nextLine());
        int depositDeadLine = Integer.parseInt(scanner.nextLine());
        double annualInterestPercentage = Double.parseDouble(scanner.nextLine());
        double sum = depositSum + depositDeadLine * ((depositSum * (annualInterestPercentage / 100)) / 12);


        System.out.println(sum);

    }
}
