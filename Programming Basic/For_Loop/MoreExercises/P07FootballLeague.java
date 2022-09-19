package For_Loop.MoreExercises;

import java.util.Scanner;

public class P07FootballLeague {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int stadiumCapacity = Integer.parseInt(scanner.nextLine());
        int totalFans = Integer.parseInt(scanner.nextLine());

        double fansInSectorA = 0;
        double fansInSectorB = 0;
        double fansInSectorV = 0;
        double fansInSectorG = 0;

        for (int i = 0; i < totalFans; i++) {
            String sector = scanner.nextLine();

            switch (sector) {
                case "A":
                    fansInSectorA++;
                    break;
                case "B":
                    fansInSectorB++;
                    break;
                case "V":
                    fansInSectorV++;
                    break;
                case "G":
                    fansInSectorG++;
                    break;
            }

        }
        System.out.printf("%.2f%%\n", fansInSectorA / totalFans * 100);
        System.out.printf("%.2f%%\n", fansInSectorB / totalFans * 100);
        System.out.printf("%.2f%%\n", fansInSectorV / totalFans * 100);
        System.out.printf("%.2f%%\n", fansInSectorG / totalFans * 100);
        System.out.printf("%.2f%%", totalFans * 1.0 / stadiumCapacity * 100);
    }
}
