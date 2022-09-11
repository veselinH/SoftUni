package ConditionalStatementsAdvanced.Lab;

import java.util.Scanner;

public class P12TradeCommissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String city = scanner.nextLine();
        double s = Double.parseDouble(scanner.nextLine()); // обем на продажби

        if (city.equals("Sofia")) {
            if (s >= 0 && s <= 500) {
                double commission = s * 0.05;
                System.out.printf("%.2f", commission);
            } else if (s > 500 && s <= 1000) {
                double commission = s * 0.07;
                System.out.printf("%.2f", commission);
            } else if (s > 1000 && s <= 10000) {
                double commission = s * 0.08;
                System.out.printf("%.2f", commission);
            } else if (s > 10000) {
                double commission = s * 0.12;
                System.out.printf("%.2f", commission);
            } else {
                System.out.println("error");
            }
        } else if (city.equals("Varna")) {
            if (s >= 0 && s <= 500) {
                double commission = s * 0.045;
                System.out.printf("%.2f", commission);
            } else if (s > 500 && s <= 1000) {
                double commission = s * 0.075;
                System.out.printf("%.2f", commission);
            } else if (s > 1000 && s <= 10000) {
                double commission = s * 0.10;
                System.out.printf("%.2f", commission);
            } else if (s > 10000) {
                double commission = s * 0.13;
                System.out.printf("%.2f", commission);
            } else {
                System.out.println("error");
            }

        } else if (city.equals("Plovdiv")) {
            if (s >= 0 && s <= 500) {
                double commission = s * 0.055;
                System.out.printf("%.2f", commission);
            } else if (s > 500 && s <= 1000) {
                double commission = s * 0.08;
                System.out.printf("%.2f", commission);
            } else if (s > 1000 && s <= 10000) {
                double commission = s * 0.12;
                System.out.printf("%.2f", commission);
            } else if (s > 10000) {
                double commission = s * 0.145;
                System.out.printf("%.2f", commission);
            } else {
                System.out.println("error");
            }

        } else {
            System.out.println("error");
        }


    }
}


