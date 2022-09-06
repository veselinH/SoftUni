package FirstStepsInCoding.MoreExercise;

import java.util.Scanner;

public class WeatherForecast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String hint = scanner.nextLine();

        if (hint.equals("sunny")) {
            System.out.println("It's warm outside!");

        } else {
            System.out.println("It's cold outside!");
        }


        }
    }
