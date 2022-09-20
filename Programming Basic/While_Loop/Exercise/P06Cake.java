package While_Loop.Exercise;

import java.util.Scanner;

public class P06Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        int cakePieces = a * b;
        boolean noPieces = false;
        String cancel = scanner.nextLine();
        while (!cancel.equals("STOP")) {
            int pieceTaken = Integer.parseInt(cancel);
            cakePieces -= pieceTaken;
            if (cakePieces <= 0) {
                noPieces = true;
                break;
            }
            cancel = scanner.nextLine();
        }
        if (noPieces) {
            System.out.printf("No more cake left! You need %d pieces more.", Math.abs(cakePieces));
        } else {
            System.out.printf("%d pieces are left.", Math.abs(cakePieces));
        }

    }
}
