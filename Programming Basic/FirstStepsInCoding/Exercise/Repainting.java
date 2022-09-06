package FirstStepsInCoding.Exercise;

import java.util.Scanner;

public class Repainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int plasticNeeded = Integer.parseInt(scanner.nextLine());
        int paintLitres = Integer.parseInt(scanner.nextLine());
        int paintThinner = Integer.parseInt(scanner.nextLine());
        int hoursWorkingTime = Integer.parseInt(scanner.nextLine());

        double plasticPrice = 1.5;
        double paintPrice = 14.50;
        double thinnerPrice = 5.00;

        double plasticCost = (plasticNeeded + 2) * plasticPrice;
        double paintCost = (paintLitres + (paintLitres * 0.10)) * paintPrice;
        double thinnerCost = paintThinner * thinnerPrice;
        double bagsCost = 0.40;
        double totalMaterialsCost = plasticCost + paintCost + thinnerCost + bagsCost;
        double workersTimePerHour = totalMaterialsCost * (30.0 / 100);
        double workersCost = hoursWorkingTime * workersTimePerHour;

        double finalSum = totalMaterialsCost + workersCost;

        System.out.println(finalSum);


    }
}
