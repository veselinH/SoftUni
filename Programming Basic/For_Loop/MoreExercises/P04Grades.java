package For_Loop.MoreExercises;

import java.util.Scanner;

public class P04Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());

        int grade1count = 0; // students grade >= 5
        int grade2count = 0; // between 4.00 and 4.99
        int grade3count = 0; // between 3.00 and 3.99
        int grade4count = 0; // students grade < 3;
        double gradesSum = 0;

        for (int i = 1; i <= students; i++) {
            double grade = Double.parseDouble(scanner.nextLine());
            gradesSum += grade;
            if (grade >= 5) {
                grade1count++;
            } else if (grade >= 4) {
                grade2count++;
            } else if (grade >= 3) {
                grade3count++;
            } else {
                grade4count++;
            }


        }
        int totalGrades = grade1count + grade2count + grade3count + grade4count;

        System.out.printf("Top students: %.2f%%\n", grade1count * 1.0 / totalGrades * 100);
        System.out.printf("Between 4.00 and 4.99: %.2f%%\n", grade2count * 1.0 / totalGrades * 100);
        System.out.printf("Between 3.00 and 3.99: %.2f%%\n", grade3count * 1.0 / totalGrades * 100);
        System.out.printf("Fail: %.2f%%\n", grade4count * 1.0 / totalGrades * 100);
        System.out.printf("Average: %.2f", gradesSum * 1.0 / students);

    }
}
