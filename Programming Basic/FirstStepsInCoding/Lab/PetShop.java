package FirstStepsInCoding.Lab;

import java.util.Scanner;

public class PetShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dogFoodCount = Integer.parseInt(scanner.nextLine());
        int catFoodCount = Integer.parseInt(scanner.nextLine());
        double dogFood = 2.50;
        double catFood = 4;
        double dogSum = dogFood * dogFoodCount;
        double catSum = catFood * catFoodCount;
        double finalSum = dogSum + catSum;


        System.out.println(finalSum + " lv.");


    }
}
