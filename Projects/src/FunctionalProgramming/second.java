package FunctionalProgramming;

import java.util.Scanner;

/**
 * Created by Happiness on 3.6.2016 г..
 */
public class second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        String input2 = scanner.nextLine();
        int start = Integer.parseInt(input[0]);
        int stop = Integer.parseInt(input[1]);
        for (int i =start; i <= stop; i++) {
           switch(input2){
               case "odd" :
                   if(i%2!=0){
                       System.out.println(i);
                   }
                   break;
               case "even" :
                   if(i%2==0){
                       System.out.println(i);
                   }
                   break;
           }
        }

    }
}
