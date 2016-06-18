package API;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class first {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        HashMap<String,Integer> map = new HashMap<>();
        while(!input.equals("END")){

            //String[] asd = input.split("(.+)([0-9])");
            Pattern pattern = Pattern.compile("(.+)([0-9])");
            Matcher matcher = pattern.matcher(input);
            if(matcher.find()){
                int number = Integer.parseInt(matcher.group(2));
                map.put(matcher.group(1),number);
            }


            input=scanner.nextLine();

        }
        map.entrySet().stream()
                .filter( g -> g.getValue()==2)
                .sorted((a,a1)->{
                    String[] asd = a.getKey().split(" ");
                    String[] asd1 = a1.getKey().split(" ");
                    return asd[0].compareTo(asd1[0]);
                })
                .forEach(a-> System.out.printf("%s%n",a.getKey()));
    }
}
