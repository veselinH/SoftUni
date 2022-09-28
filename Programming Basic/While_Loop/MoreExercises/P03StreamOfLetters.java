package While_Loop.MoreExercises;

import java.util.Scanner;

public class P03StreamOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String secretCode = "";
        int secretSymbolCount = 0;
        int caseC = 1;
        int caseO = 1;
        int caseN = 1;

        String input = scanner.nextLine();

        while (!input.equals("End")){
            char currentSymbol = input.charAt(0);
            switch (input){
                case "c":
                    if (caseC % 2 == 0){
                        secretCode += currentSymbol;
                    }
                    caseC++;
                    secretSymbolCount++;
                    break;
                case "o":
                    if (caseO % 2 == 0){
                        secretCode += currentSymbol;
                    }
                    caseO++;
                    secretSymbolCount++;
                    break;
                case "n":
                    if (caseN % 2 == 0){
                        secretCode += currentSymbol;
                    }
                    caseN++;
                    secretSymbolCount++;
                    break;
                default:
                    secretCode += currentSymbol;
                    break;
            }
            if (secretSymbolCount % 3 == 0){
                secretCode += " ";
            }

            input = scanner.nextLine();
        }
        System.out.println(secretCode);
    }
}
