package FirstStepsInCoding.MoreExercise;

import java.util.Scanner;

public class TrainingLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double h = Double.parseDouble(scanner.nextLine()); // in meters
        double w = Double.parseDouble(scanner.nextLine()); // in meters

        double wInCM = w * 100 - 100;
        double seats = Math.floor(wInCM / 70);

        double hInCM = h * 100;
        double rolls = Math.floor(hInCM / 120);

        double allSeats = (seats * rolls) - 3;

        System.out.printf("%.0f", allSeats);


    }
}
