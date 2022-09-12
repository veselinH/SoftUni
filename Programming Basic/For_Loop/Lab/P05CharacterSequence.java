package For_Loop.Lab;

import java.util.Scanner;

public class P05CharacterSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine(); //        SOFTUNI

        for (int position = 0; position <= text.length() - 1; position++) {
            char currentSymbol = text.charAt(position);  // казваме да чете символите
            System.out.println(currentSymbol);
        }
    }
}
