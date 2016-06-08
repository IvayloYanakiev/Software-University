package SetsMaps;


import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class sixth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        TreeMap<String,Integer> map = new TreeMap<>();
        int count = 0;



while(!s.equals("stop")) {
    if (count % 2 == 0) {
        String name = s;
        s = scanner.nextLine();
        if (map.containsKey(name)) {
            map.put(name, map.get(name) + Integer.parseInt(s));
        }
        if (!map.containsKey(name)) {
            map.put(name, Integer.parseInt(s));
        }
        count += 2;
    }
    s=scanner.nextLine();
}
        for (Map.Entry<String,Integer> asd : map.entrySet()) {
            String key = asd.getKey();
            Integer value = asd.getValue();
            System.out.printf("%s -> %d",key,value);
            System.out.println();
        }

    }
}
