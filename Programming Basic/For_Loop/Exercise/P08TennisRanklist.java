package For_Loop.Exercise;

import java.util.Scanner;

public class P08TennisRanklist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tournamentsCount = Integer.parseInt(scanner.nextLine());
        int startingPoints = Integer.parseInt(scanner.nextLine());

        int finalPoints = startingPoints;
        double average = 0.00;
        double winCount = 0.00;

        for (int i = 1; i <= tournamentsCount; i++) {
            String position = scanner.nextLine();

            switch (position) {
                case "W":
                    finalPoints += 2000;
                    average += 2000;
                    winCount++;
                    break;
                case "F":
                    finalPoints += 1200;
                    average += 1200;
                    break;
                case "SF":
                    finalPoints += 720;
                    average += 720;
                    break;


            }
        }
        average /= tournamentsCount;
        average = Math.floor(average);

        double winPercentage = (winCount / tournamentsCount) * 100;

        System.out.println("Final points: " + finalPoints);
        System.out.printf("Average points: %.0f\n", average);
        System.out.printf("%.2f%%", winPercentage);
    }
}
