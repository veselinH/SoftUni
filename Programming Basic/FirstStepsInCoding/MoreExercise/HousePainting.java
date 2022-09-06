package FirstStepsInCoding.MoreExercise;

import java.util.Scanner;

public class HousePainting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x = Double.parseDouble(scanner.nextLine()); // височина на къщата
        double y = Double.parseDouble(scanner.nextLine()); // дължина на страничната стена
        double h = Double.parseDouble(scanner.nextLine()); // височина на триъгълната стена на покрива

        //Walls - green paint

        double sideS = x * y;
        double windowS = 1.5 * 1.5;
        double twoSides = 2 * sideS - 2 * windowS;

        double back = x * x;
        double entrance = 1.2 * 2;

        double frontAndBack = back * 2 - entrance;
        double allDownArea = twoSides + frontAndBack;

        double greenPaint = allDownArea / 3.4;

        // Roof - red paint

        double twoSideRoof = (x * y) * 2;
        double frontAndBackRoof = 2 * (x * h / 2);
        double allRoofArea = twoSideRoof + frontAndBackRoof;

        double redPaint = allRoofArea / 4.3;

        System.out.printf("%.2f %n", greenPaint);
        System.out.printf("%.2f", redPaint);
    }
}
