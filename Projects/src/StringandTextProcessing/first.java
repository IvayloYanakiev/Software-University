package StringandTextProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Happiness on 30.5.2016 г..
 */
public class first {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        list.add("asd");
        double a = 5.4;
        String d = "3.2";
        System.out.println(a+d);
String asd = "asd";

        String input = scanner.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = input.length()-1; i >=0; i--) {
           sb.append(input.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
