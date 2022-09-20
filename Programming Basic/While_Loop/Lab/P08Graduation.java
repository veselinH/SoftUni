package While_Loop.Lab;

import java.util.Scanner;

public class P08Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String student = scanner.nextLine();
        double totalGrade = 0.00;
        double grade = 0.00;
        int sClass = 1;

        while (sClass <= 12){
            grade = Double.parseDouble(scanner.nextLine());
            totalGrade += grade;
            if (grade < 4){
                System.out.printf("%s has been excluded at %d grade", student, sClass);
                break;
            }
            sClass++;
        }
        double averageGrade = totalGrade / 12;
        if (grade >= 4) {
            System.out.printf("%s graduated. Average grade: %.2f", student, averageGrade);
        }

  /*      for (int sClass = 1; sClass <= 12; sClass++) {
            grade = Double.parseDouble(scanner.nextLine());
            totalGrade += grade;
            if (grade < 4) {
                System.out.printf("%s has been excluded at %d grade", student, sClass);
                break;
            }
        }
        double averageGrade = totalGrade / 12;
        if (grade >= 4) {
            System.out.printf("%s graduated. Average grade: %.2f", student, averageGrade);
        }*/

    }
}
