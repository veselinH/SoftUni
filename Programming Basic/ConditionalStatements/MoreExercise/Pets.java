    package ConditionalStatements.MoreExercise;

    import java.util.Scanner;

    public class Pets {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Прочитаме входа

            int days = Integer.parseInt(scanner.nextLine());            // дните в които отсъства
            int foodLeft = Integer.parseInt(scanner.nextLine());        // оставена храна в килограми
            double dogFood = Double.parseDouble(scanner.nextLine());    // храна за кучето на ден в килограми
            double catFood = Double.parseDouble(scanner.nextLine());    // храна за котката на ден в килограми
            double turtleFood = Double.parseDouble(scanner.nextLine()); // храна за костенурката на ден в грамове

            // Изчисляваме

            double dogFoodTotal = dogFood * days;
            double catFoodTotal = catFood * days;
            double turtleFoodTotal = (turtleFood / 1000.0) * days; // първо превръщаме грамовете в килограми

            double totalFoodNeeded = dogFoodTotal + catFoodTotal + turtleFoodTotal;
            double diff = Math.abs(totalFoodNeeded - foodLeft);

            if (totalFoodNeeded <= foodLeft) {
                double diffRounded = Math.floor(diff);
                System.out.printf("%.0f kilos of food left.", diffRounded);

            } else {
                double diffRounded = Math.ceil(diff);
                System.out.printf("%.0f more kilos of food are needed.", diffRounded);
            }
        }
    }
