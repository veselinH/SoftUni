package FirstStepsInCoding.Lab;

import java.util.Scanner;

public class InchesToCentimeters {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double inch = Double.parseDouble(input);
        double cm = inch * 2.54;
        System.out.println(cm);
    }



}

