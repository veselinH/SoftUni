package For_Loop.MoreExercises;

import java.util.Scanner;

public class P02Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double days = Integer.parseInt(scanner.nextLine());

        int doctors = 7;
        int treatedPatientsTotal = 0;
        int untreatedPatientsTotal = 0;

        for (double i = 1; i <= days; i++) {
            int treatedPatients = 0;
            int untreatedPatients = 0;
            if (i % 3 == 0 && untreatedPatientsTotal > treatedPatientsTotal) {
                doctors++;
            }
            int patients = Integer.parseInt(scanner.nextLine());
            if (patients >= doctors) {
                treatedPatients += doctors;
                treatedPatientsTotal += treatedPatients;
            } else {
                treatedPatients += patients;
                treatedPatientsTotal += treatedPatients;
            }
            untreatedPatients += patients - treatedPatients;
            untreatedPatientsTotal += untreatedPatients;

        }
        System.out.println("Treated patients: " + treatedPatientsTotal + ".");
        System.out.println("Untreated patients: " + untreatedPatientsTotal + ".");
    }
}
