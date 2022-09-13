package For_Loop.Exercise;

import java.util.Scanner;

public class P09TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groupsCount = Integer.parseInt(scanner.nextLine());
        int musala = 0;
        int montBlanc = 0;
        int kilimanjaro = 0;
        int k2 = 0;
        int everest = 0;
        int totalPeople = 0;
        for (int i = 1; i <= groupsCount; i++) {
            int peopleInGroup = Integer.parseInt(scanner.nextLine());
            totalPeople += peopleInGroup;
            if (peopleInGroup <= 5) {
                musala += peopleInGroup;
            } else if (peopleInGroup <= 12) {
                montBlanc += peopleInGroup;
            } else if (peopleInGroup <= 25) {
                kilimanjaro += peopleInGroup;
            } else if (peopleInGroup <= 40) {
                k2 += peopleInGroup;
            } else {
                everest += peopleInGroup;
            }
        }
        System.out.printf("%.2f%%\n", musala * 1.0 / totalPeople * 100);
        System.out.printf("%.2f%%\n", montBlanc * 1.0 / totalPeople * 100);
        System.out.printf("%.2f%%\n", kilimanjaro * 1.0 / totalPeople * 100);
        System.out.printf("%.2f%%\n", k2 * 1.0 / totalPeople * 100);
        System.out.printf("%.2f%%\n", everest * 1.0 / totalPeople * 100);
    }
}
