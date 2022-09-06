package ConditionalStatements.Exercise;

import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double record = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double timeFor1Meter = Double.parseDouble(scanner.nextLine());

        double ivanTime = distance * timeFor1Meter;
        double delay1 = Math.floor(distance / 15);
        double delay =delay1 * 12.5;

        double finalIvanTime = ivanTime + delay;


        if (finalIvanTime < record) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", finalIvanTime);
        } else {
            System.out.printf("No, he failed! He was %.2f seconds slower.", Math.abs(finalIvanTime - record));
        }
    }
}
