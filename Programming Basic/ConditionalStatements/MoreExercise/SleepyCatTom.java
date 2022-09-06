package ConditionalStatements.MoreExercise;

import java.util.Scanner;

public class SleepyCatTom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int restDays = Integer.parseInt(scanner.nextLine());

        int norm = 30000;

        int restDaysPlayInMinutes = restDays * 127;
        int workDaysPlayInMinutes = (365 - restDays) * 63;
        int totalPlayMinutes = restDaysPlayInMinutes + workDaysPlayInMinutes;
        int diff = Math.abs(norm - totalPlayMinutes);
        int hours = diff / 60;
        int seconds = diff % 60;


        if (totalPlayMinutes <= norm) {
            System.out.println("Tom sleeps well");
            System.out.printf("%d hours and %d minutes less for play", hours, seconds);
        } else {
            System.out.println("Tom will run away");
            System.out.printf("%d hours and %d minutes more for play", hours, seconds);
        }

    }
}
