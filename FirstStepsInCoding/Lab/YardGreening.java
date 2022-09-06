package FirstStepsInCoding.Lab;

import java.util.Scanner;

public class YardGreening {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double yards = Double.parseDouble(scanner.nextLine());

        double fullPrice = yards * 7.61;
        double discount = fullPrice * (18.0 / 100);
        double finalPrice = fullPrice - discount;

        System.out.println("The final price is: " + finalPrice + " lv.");
        System.out.println("The discount is: " + discount + " lv.");


    }
}
