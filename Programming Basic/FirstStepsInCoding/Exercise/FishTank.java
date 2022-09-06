package FirstStepsInCoding.Exercise;

import java.util.Scanner;

public class FishTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lengthCM = Integer.parseInt(scanner.nextLine());
        int widthCM = Integer.parseInt(scanner.nextLine());
        int heightCM = Integer.parseInt(scanner.nextLine());
        double percentage = Double.parseDouble(scanner.nextLine());

        double aquariumVolume = lengthCM * widthCM * heightCM;
        double aquariumVolumeInLitres = aquariumVolume / 1000;
        double occupiedSpace = percentage / 100;

        double litersNeeded = aquariumVolumeInLitres * (1 - occupiedSpace);

        System.out.println(litersNeeded);

    }
}
