package ConditionalStatementsAdvanced.MoreExercise;

import java.util.Scanner;

public class P07SchoolCamp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        String groupType = scanner.nextLine();
        int studentsCount = Integer.parseInt(scanner.nextLine());
        int nightsCount = Integer.parseInt(scanner.nextLine());

        String sportType = "";
        double hotelCost = 0.00;

        switch (season) {
            case "Winter":
                switch (groupType) {
                    case "boys":
                        hotelCost = nightsCount * 9.60 * studentsCount;
                        sportType = "Judo";
                        break;
                    case "girls":
                        hotelCost = nightsCount * 9.60 * studentsCount;
                        sportType = "Gymnastics";
                        break;
                    case "mixed":
                        hotelCost = nightsCount * 10 * studentsCount;
                        sportType = "Ski";
                        break;

                }
                break;
            case "Spring":
                switch (groupType) {

                    case "boys":
                        hotelCost = nightsCount * 7.20 * studentsCount;
                        sportType = "Tennis";
                        break;

                    case "girls":
                        hotelCost = nightsCount * 7.20 * studentsCount;
                        sportType = "Athletics";
                        break;

                    case "mixed":
                        hotelCost = nightsCount * 9.50 * studentsCount;
                        sportType = "Cycling";
                        break;
                }
                break;
            case "Summer":
                switch (groupType) {

                    case "boys":
                        hotelCost = nightsCount * 15 * studentsCount;
                        sportType = "Football";
                        break;

                    case "girls":
                        hotelCost = nightsCount * 15 * studentsCount;
                        sportType = "Volleyball";
                        break;

                    case "mixed":
                        hotelCost = nightsCount * 20 * studentsCount;
                        sportType = "Swimming";
                        break;
                }
                break;
        }


        if (studentsCount >= 10 && studentsCount < 20) {
            hotelCost *= 0.95;
        } else if (studentsCount >= 20 && studentsCount < 50) {
            hotelCost *= 0.85;
        } else if (studentsCount >= 50) {
            hotelCost *= 0.50;
        }
        System.out.printf("%s %.2f lv.", sportType, hotelCost);
    }
}
