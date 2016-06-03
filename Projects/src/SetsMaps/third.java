package SetsMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by Happiness on 5/18/2016.
 */
public class third {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();

        TreeSet<String> set = new TreeSet<>();

        for(int i = 0 ; i<Integer.parseInt(number);i++){
            String input = scanner.nextLine();
            String[] a = input.split(" ");
            for (int j = 0; j < a.length; j++) {
                set.add(a[j]);
            }

        }
        for (String s : set) {
            System.out.print(s+ " ");
        }
        scanner.close();
    }
}
