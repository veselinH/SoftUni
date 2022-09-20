package While_Loop.Exercise;

import java.util.Scanner;

public class P01OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String bookName = scanner.nextLine();
        String searchedBook = scanner.nextLine();
        boolean isFound = false;
        int bookCount = 0;
        while (!searchedBook.equals("No More Books")){
            if (searchedBook.equals(bookName)){
                isFound = true;
                break;
            }
            bookCount++;
            searchedBook = scanner.nextLine();
        }
        if (isFound) {
            System.out.printf("You checked %d books and found it.", bookCount);
        } else {
            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.", bookCount);
        }


    }
}
