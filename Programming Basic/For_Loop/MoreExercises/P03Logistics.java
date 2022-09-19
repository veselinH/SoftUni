package For_Loop.MoreExercises;

import java.util.Scanner;

public class P03Logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cargoCount = Integer.parseInt(scanner.nextLine());

        double deliveryCost = 0;
        int weightTotal = 0;
        int byMinibusWeightTotal = 0;
        int byTruckWeightTotal = 0;
        int byTrainWeightTotal = 0;


        for (int i = 1; i <= cargoCount; i++) {
            int cargoWeight = Integer.parseInt(scanner.nextLine());
            if (cargoWeight <= 3) {
                deliveryCost += cargoWeight * 200;
                byMinibusWeightTotal += cargoWeight;
            } else if (cargoWeight <= 11) {
                deliveryCost += cargoWeight * 175;
                byTruckWeightTotal += cargoWeight;
            } else {
                deliveryCost += cargoWeight * 120;
                byTrainWeightTotal += cargoWeight;
            }
            weightTotal += cargoWeight;

        }
        double averageDeliveryCost = deliveryCost / weightTotal;

        System.out.printf("%.2f\n", averageDeliveryCost);
        System.out.printf("%.2f%%\n", byMinibusWeightTotal * 1.0 / weightTotal * 100);
        System.out.printf("%.2f%%\n", byTruckWeightTotal * 1.0 / weightTotal * 100);
        System.out.printf("%.2f%%\n", byTrainWeightTotal * 1.0 / weightTotal * 100);

    }
}
