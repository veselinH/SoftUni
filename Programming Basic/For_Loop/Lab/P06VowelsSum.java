package For_Loop.Lab;

import java.util.Scanner;

public class P06VowelsSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        int result = 0;

        for (int position = 0; position <= text.length() - 1; position++) {
            char symbol = text.charAt(position);

            switch (symbol) {
                case 'a':
                    result += 1;
                    break;
                case 'e':
                    result += 2;
                    break;
                case 'i':
                    result += 3;
                    break;
                case 'o':
                    result += 4;
                    break;
                case 'u':
                    result += 5;
                    break;
            }

        }
        System.out.println(result);


    }
}
