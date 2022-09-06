package ConditionalStatements.MoreExercise;

import java.util.Scanner;

public class FlowerShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Прочитаме входа
        // Брой магнолии – цяло число в интервала [0 … 50]
        // Брой зюмбюли – цяло число в интервала [0 … 50]
        // Брой рози – цяло число в интервала [0 … 50]
        // Брой кактуси – цяло число в интервала [0 … 50]
        // Цена на подаръка – реално число в интервала [0.00 … 500.00]

        int magnolia = Integer.parseInt(scanner.nextLine());       // магнолии
        int hyacinth = Integer.parseInt(scanner.nextLine());       // зюмбюли
        int roses = Integer.parseInt(scanner.nextLine());          // рози
        int cactus = Integer.parseInt(scanner.nextLine());         // кактуси
        double giftPrice = Double.parseDouble(scanner.nextLine()); // цена на подаръка

        // Изчисляваме

        //Цени на цветята
        // Магнолии – 3.25 лева
        // Зюмбюли – 4 лева
        // Рози – 3.50 лева
        // Кактуси – 8 лева

        double magnoliaPrice = magnolia * 3.25;
        double hyacinthPrice = hyacinth * 4;
        double rosesPrice = roses * 3.50;
        double cactusPrice = cactus * 8;

        // крайната печалба след 5% данък
        double totalIncome = (magnoliaPrice + hyacinthPrice + rosesPrice + cactusPrice) * 0.95;

        double diff = Math.abs(totalIncome - giftPrice);

        if (totalIncome >= giftPrice) {
            double diffFloored = Math.floor(diff);
            System.out.printf("She is left with %.0f leva.", diffFloored);
        } else {
            double diffCeiled = Math.ceil(diff);
            System.out.printf("She will have to borrow %.0f leva.", diffCeiled);
        }


    }
}
