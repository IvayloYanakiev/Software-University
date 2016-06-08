package FunctionalProgramming;

import java.util.Scanner;

/**
 * Created by Happiness on 3.6.2016 г..
 */
public class first {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int min = Integer.parseInt(input[0]);
        for (int i = 1; i < input.length; i++) {
            if(min>Integer.parseInt(input[i])){
                min = Integer.parseInt(input[i]);
            }
            else {continue;}
        }
        System.out.println(min);
    }
}
