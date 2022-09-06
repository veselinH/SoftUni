package FirstStepsInCoding.Exercise;

import java.util.Scanner;

public class VacationBookList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bookPagesCount = Integer.parseInt(scanner.nextLine());
        int pagesPerHour = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        int oneBookTime = bookPagesCount / pagesPerHour;
        int hoursPerDay = oneBookTime / days;

        System.out.println(hoursPerDay);

    }
}
