package StringandTextProcessing;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Happiness on 30.5.2016 г..
 */
public class Fourth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input[] = scanner.nextLine().split(" ");
        int baseToConvertTo = Integer.parseInt(input[0]);
        BigInteger chislo = new BigInteger(input[1],10);
        String a = chislo.toString(baseToConvertTo);
        System.out.println(a);
    }
}
