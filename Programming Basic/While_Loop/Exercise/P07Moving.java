package While_Loop.Exercise;

import java.util.Scanner;

public class P07Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int widthApartment = Integer.parseInt(scanner.nextLine());
        int lengthApartment = Integer.parseInt(scanner.nextLine());
        int heightApartment = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine(); // "Done"
        int boxesInCube = 0;
        int apartmentInCube = widthApartment * lengthApartment * heightApartment;
        boolean noSpace = false;

        while (!input.equals("Done")) {
            int box = Integer.parseInt(input);
            boxesInCube += box;
            if (boxesInCube > apartmentInCube) {
                noSpace = true;
                break;
            }
            input = scanner.nextLine();
        }
        if (noSpace) {
            System.out.printf("No more free space! You need %d Cubic meters more.", Math.abs(boxesInCube - apartmentInCube));
        } else {
            System.out.printf("%d Cubic meters left.", Math.abs(boxesInCube - apartmentInCube));
        }

    }
}
