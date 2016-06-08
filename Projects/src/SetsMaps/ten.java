package SetsMaps;


import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class ten {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        HashMap<String, LinkedHashMap<String, BigInteger>> map = new HashMap<>();
        LinkedHashMap<String, BigInteger> map2 = new LinkedHashMap<>();
        while (!input.equals("report")) {
            String[] inputTokens = input.split("\\|");
            String country = inputTokens[1];
            String city = inputTokens[0];
            String population = inputTokens[2];
            if (!map.containsKey(country)) {
                LinkedHashMap<String, BigInteger> map1 = new LinkedHashMap<>();
                map.put(country, map1);
                map.get(country).put(city, new BigInteger(population));
                map2.put(country, BigInteger.ZERO);
            }
            map2.put(country, map2.get(country).add(new BigInteger(population)));
            map.get(country).put(city, new BigInteger(population));
            input = scanner.nextLine();
        }
        map2.entrySet().stream().sorted((k, k1) -> (k1.getValue().compareTo(k.getValue())))
                .forEach(asd -> {
                    String name = asd.getKey();
                    LinkedHashMap<String, BigInteger> d = map.get(name);
                    System.out.printf("%s (total population: %d)\n", name, asd.getValue());

                    d.entrySet().stream().sorted((c, c1) -> (c1.getValue().compareTo(c.getValue()))).forEach(asd1 -> {
                        System.out.printf("=>%s: %s\n", asd1.getKey(), asd1.getValue());
                    });

                });


    }
}
