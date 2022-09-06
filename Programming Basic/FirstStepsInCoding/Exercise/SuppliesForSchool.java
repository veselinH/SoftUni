package FirstStepsInCoding.Exercise;

import java.util.Scanner;

public class SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int penPackages = Integer.parseInt(scanner.nextLine());
        int markerPackages = Integer.parseInt(scanner.nextLine());
        double boardCleanerLitres = Double.parseDouble(scanner.nextLine());
        double discountPercentage = Double.parseDouble(scanner.nextLine());

        double penPackage = 5.80;
        double markerPackage = 7.20;
        double boardCleanerPerLitre = 1.20;

        double sumPenPackages = penPackage * penPackages;
        double sumMarkerPackages = markerPackage * markerPackages;
        double sumBoardLitres = boardCleanerLitres * boardCleanerPerLitre;
        double sumAll = sumMarkerPackages + sumPenPackages + sumBoardLitres;
        double percentage = discountPercentage / 100;
        double discount = sumAll * percentage;

        double finalSum = sumAll - discount;


        System.out.println(finalSum);

    }
}
