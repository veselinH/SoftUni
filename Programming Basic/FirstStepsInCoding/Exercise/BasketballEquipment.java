package FirstStepsInCoding.Exercise;

import java.util.Scanner;

public class BasketballEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double annualBasketballTax = Double.parseDouble(scanner.nextLine());

        double basketballShoes = annualBasketballTax - (annualBasketballTax * 0.4);
        double basketballOutfit = basketballShoes - (basketballShoes * 0.2);
        double basketballBall = basketballOutfit / 4;
        double basketballAccessories = basketballBall / 5;

        double totalExpenses = annualBasketballTax + basketballShoes + basketballOutfit + basketballBall + basketballAccessories;

        System.out.println(totalExpenses);
    }
}
