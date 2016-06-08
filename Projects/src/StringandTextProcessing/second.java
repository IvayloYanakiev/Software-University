package StringandTextProcessing;

import java.util.Scanner;

/**
 * Created by Happiness on 30.5.2016 г..
 */
public class second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int number = 20 ;
        for (int i = 0; i < input.length(); i++) {
            number--;
        }
        for (int i = 0; i < number; i++) {
            input+="*";
        }
        System.out.println(input);
    }
}
