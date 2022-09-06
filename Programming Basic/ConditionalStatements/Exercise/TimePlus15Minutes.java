package ConditionalStatements.Exercise;

import java.util.Scanner;

public class TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // прочитане от конзолата -> час и минути
        // от въведените данни да се изчисли колко ще часа след 15 минути

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int hoursInMinutes = (hours * 60) + minutes; // превръщам в минути

        int afterFifteenMin = hoursInMinutes + 15;

        int afterFifteenMinInHours = afterFifteenMin / 60; // превръщам в часове
        int afterFifteenMinInMin = afterFifteenMin % 60; // изчисляваме минутите


        if (afterFifteenMinInHours > 23) {
            afterFifteenMinInHours = 0;
        }
        System.out.printf("%d:%02d", afterFifteenMinInHours, afterFifteenMinInMin);


    }
}
