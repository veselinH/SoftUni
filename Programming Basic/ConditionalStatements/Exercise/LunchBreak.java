package ConditionalStatements.Exercise;

import java.util.Scanner;

public class LunchBreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Прочитаме входа

        String tvShow = scanner.nextLine();
        int episodeLength = Integer.parseInt(scanner.nextLine());
        int breakLength = Integer.parseInt(scanner.nextLine());

        // Изчисляваме

        // Време за обяд е 1/8 от времето за почивка
        // Време за отдих е 1/4 от времето за почивка

        double lunchTime = breakLength / 8.0;
        double restTime = breakLength / 4.0;

        double timeLeft = breakLength - (lunchTime + restTime);
        double diff = Math.abs(breakLength - (episodeLength + lunchTime + restTime));
        double roundDiff = Math.ceil(diff);


        if (timeLeft >= episodeLength) {
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.", tvShow, roundDiff);
        } else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.", tvShow, roundDiff);
        }


    }
}
