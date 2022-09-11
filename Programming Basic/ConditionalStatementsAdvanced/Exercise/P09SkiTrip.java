package ConditionalStatementsAdvanced.Exercise;

import java.util.Scanner;

public class P09SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        String roomType = scanner.nextLine();
        String feedback = scanner.nextLine();

        double tripPrice = 0.00;

        switch (roomType){
            case "room for one person":
                tripPrice = (days - 1) * 18;
                break;
            case "apartment":
                if (days < 10) {
                    tripPrice = ((days - 1) * 25) * 0.70; // 30% discount
                } else if (days <= 15) {
                    tripPrice = ((days - 1) * 25) * 0.65; // 35% discount
                } else {
                    tripPrice = ((days - 1) * 25) * 0.50; // 50% discount
                }
                break;
            case "president apartment":
                if (days < 10) {
                    tripPrice = ((days - 1) * 35) * 0.90; // 10% discount
                } else if (days <= 15) {
                    tripPrice = ((days - 1) * 35) * 0.85; // 15% discount
                } else {
                    tripPrice = ((days - 1) * 35) * 0.80; // 20% discount
                }
                break;
        }

        if (feedback.equals("positive")){
            tripPrice *= 1.25;
        } else if (feedback.equals("negative")) {
            tripPrice *= 0.90;
        }

        System.out.printf("%.2f", tripPrice);

    }
}
