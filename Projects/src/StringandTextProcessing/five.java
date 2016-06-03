package StringandTextProcessing;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Happiness on 30.5.2016 г..
 */
public class five {
    public static void main(String[] argc) {
        Scanner scanner = new Scanner(System.in);

        String input[] = scanner.nextLine().split(" ");
        int baseToConvertTo = Integer.parseInt(input[0]);
        BigInteger chislo = new BigInteger(input[1],baseToConvertTo);
        String a = chislo.toString(10);
        System.out.println(a);
    }
}
