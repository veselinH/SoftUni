package ConditionalStatements.MoreExercise;

import java.util.Scanner;

public class Firm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Прочитане на входа

        int timeNeed = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());    // дните с които фирмата разполага
        int workers = Integer.parseInt(scanner.nextLine()); // служителите, които работят извънредно

        double workDayInHours = 8;
        double workHours = days * 0.90 * 8;
        double extraWorkingHours = workers * (2 * days); // извънредните часове на ден са 2
        double totalHours = workHours + extraWorkingHours;
        double totalHoursFloored = Math.floor(totalHours);
        double hoursDiff = Math.abs(totalHoursFloored - timeNeed); // разликата между часовете и нужните часове

        if (totalHoursFloored >= timeNeed) {
            System.out.printf("Yes!%.0f hours left.", hoursDiff);
        } else {
            System.out.printf("Not enough time!%.0f hours needed.", hoursDiff);

        }
    }
}
