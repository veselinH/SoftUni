package For_Loop.MoreExercises;

import java.util.Scanner;

public class P05GamesOfIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int moves = Integer.parseInt(scanner.nextLine());

        int firstDiapason = 0;
        int secondDiapason = 0;
        int thirdDiapason = 0;
        int fourthDiapason = 0;
        int fifthDiapason = 0;
        int invalidDiapason = 0;
        double totalPoints = 0;

        for (int i = 1; i <= moves; i++) {
            int move = Integer.parseInt(scanner.nextLine());

            if (move >= 0 && move <= 9) {
                firstDiapason++;
                totalPoints += move * 0.20;
            } else if (move >= 10 && move <= 19) {
                secondDiapason++;
                totalPoints += move * 0.30;
            } else if (move >= 20 && move <= 29) {
                thirdDiapason++;
                totalPoints += move * 0.40;
            } else if (move >= 30 && move <= 39) {
                fourthDiapason++;
                totalPoints += 50;
            } else if (move >= 40 && move <= 50) {
                fifthDiapason++;
                totalPoints += 100;
            } else {
                invalidDiapason++;
                totalPoints /= 2;
            }
        }
        System.out.printf("%.2f\n", totalPoints);
        System.out.printf("From 0 to 9: %.2f%%\n", firstDiapason * 1.0 / moves * 100);
        System.out.printf("From 10 to 19: %.2f%%\n", secondDiapason * 1.0 / moves * 100);
        System.out.printf("From 20 to 29: %.2f%%\n", thirdDiapason * 1.0 / moves * 100);
        System.out.printf("From 30 to 39: %.2f%%\n", fourthDiapason * 1.0 / moves * 100);
        System.out.printf("From 40 to 50: %.2f%%\n", fifthDiapason * 1.0 / moves * 100);
        System.out.printf("Invalid numbers: %.2f%%", invalidDiapason * 1.0 / moves * 100);
    }
}
