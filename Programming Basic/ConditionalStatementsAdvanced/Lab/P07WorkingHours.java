package ConditionalStatementsAdvanced.Lab;

import java.util.Scanner;

public class P07WorkingHours {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dayHour = Integer.parseInt(scanner.nextLine());
        String dayOfWeek = scanner.nextLine();

        String shopStatus = "";

        switch (dayOfWeek) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
            case "Saturday":
                if (dayHour >= 10 && dayHour <= 18) {
                    shopStatus = "open";
                } else {
                    shopStatus = "closed";
                }
                break;
            default:
                shopStatus = "closed";
        }
        System.out.println(shopStatus);
    }
}
