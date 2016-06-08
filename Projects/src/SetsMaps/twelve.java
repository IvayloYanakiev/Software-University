package SetsMaps;

import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class twelve {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashMap<String,LinkedHashMap<String, BigInteger>> namesnumber = new LinkedHashMap<>();
        while (!input.equals("End")) {
            Pattern pattern = Pattern.compile("([a-zA-Z\\s]+)\\s@([a-zA-Z\\s]+)\\s([0-9]+)\\s([0-9]+)");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group(1);
                String city = matcher.group(2);
                Long priceofticket = Long.parseLong(matcher.group(3)) * Long.parseLong(matcher.group(4));

                if (!namesnumber.containsKey(city)) {
                    LinkedHashMap<String,BigInteger> aa = new LinkedHashMap<>();
                    if(!aa.containsKey(name)){
                        namesnumber.put(city,aa);
                        namesnumber.get(city).put(name,new BigInteger(priceofticket.toString()));
                    }
                    else{
                        namesnumber.get(city).put(name,namesnumber.get(city).get(name).add(new BigInteger(priceofticket.toString())));
                    }

                } else {
                    if(!namesnumber.get(city).containsKey(name)){

                        namesnumber.get(city).put(name,new BigInteger(priceofticket.toString()));
                    }
                    else{
                        namesnumber.get(city).put(name,namesnumber.get(city).get(name).add(new BigInteger(priceofticket.toString())));
                    }

                }
            }
            input = scanner.nextLine();

        }


        namesnumber.entrySet().stream().forEach(a -> {
            String city = a.getKey();
            System.out.println(city);

            HashMap<String,BigInteger> mapa = namesnumber.get(city);

            mapa.entrySet().stream().sorted((k, k1) -> (k1.getValue().compareTo(k.getValue()))).forEach(asd -> {

                System.out.printf("#  %s -> %d\n", asd.getKey(), mapa.get(asd.getKey()));

            });


        });

    }
}
