package ConditionalStatementsAdvanced.Exercise;

import java.util.Scanner;

public class P08OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int examHour = Integer.parseInt(scanner.nextLine());
        int examMinute = Integer.parseInt(scanner.nextLine());
        int arrivalHour = Integer.parseInt(scanner.nextLine());
        int arrivalMinute = Integer.parseInt(scanner.nextLine());

        int examTime = examHour * 60 + examMinute;
        int arriveTime = arrivalHour * 60 + arrivalMinute;

        int diff = Math.abs(examTime - arriveTime);
        String output = "";
        String timeStatus = "";
        if (arriveTime < examTime - 30) {
            timeStatus = "Early";
            if (diff < 60) {
                output = String.format("%d minutes before the start", diff);
            } else {
                int h = diff / 60;
                int m = diff % 60;
                output = String.format("%d:%02d hours before the start", h, m);
            }

        } else if (arriveTime <= examTime) {
            timeStatus = "On time";

                output = String.format("%d minutes before the start", diff);

        } else {
            timeStatus = "Late";
            if (diff < 60) {
                output = String.format("%d minutes after the start", diff);
            } else {
                int h = diff / 60;
                int m = diff % 60;
                output = String.format("%d:%02d hours after the start", h, m);
            }

        }
        System.out.println(timeStatus);
        System.out.println(output);
    }
}


