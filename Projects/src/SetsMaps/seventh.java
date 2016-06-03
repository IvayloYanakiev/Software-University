package SetsMaps;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class seventh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        int count = 0;



        while(!s.equals("stop")) {
            if (count % 2 == 0) {
                String name = s;
                s = scanner.nextLine();



                    if(!s.endsWith("us")&& !s.endsWith("uk")){
                    map.put(name, s);
                }
                count += 2;
            }
            s=scanner.nextLine();
        }
        for (Map.Entry<String,String> asd : map.entrySet()) {
            String key = asd.getKey();
            String value = asd.getValue();
            System.out.printf("%s -> %s",key,value);
            System.out.println();
        }

    }
}
