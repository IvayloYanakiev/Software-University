package SetsMaps;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LegendaryFarming {


    public static void main(String[] args) {

        TreeMap<String, Integer> important = new TreeMap<>();
        TreeMap<String, Integer> junk = new TreeMap<>();
        important.put("motes", 0);
        important.put("fragments", 0);
        important.put("shards", 0);
        int stop = 1;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (input.length() > 0) {
            Pattern pattern = Pattern.compile("([0-9]+)\\s*?([a-z-_A-Z]+)");
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                int number = Integer.parseInt(matcher.group(1));
                String material = matcher.group(2).toLowerCase();
                if (material.equals("motes")) {
                    important.put("motes", important.get("motes") + number);

                    if (important.get("motes") >= 250) {
                        System.out.println("\nDragonwrath obtained!");
                        important.put("motes", important.get("motes") - 250);
                        important.entrySet().stream()
                                .sorted((k1, k2) -> k2.getValue().compareTo(k1.getValue()))
                                .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));
                        for (Entry<String, Integer> entry : junk.entrySet()) {
                            String key = entry.getKey();
                            Integer value = entry.getValue();
                            System.out.printf("%s: %d\n", key, value);

                        }
                        stop = 0;
                        break;
                    }
                }

                if (material.equals("fragments")) {
                    important.put("fragments", important.get("fragments") + number);
                    if (important.get("fragments") >= 250) {
                        System.out.println("\nValanyr obtained!");
                        important.put("fragments", important.get("fragments") - 250);
                        important.entrySet().stream()
                                .sorted((k1, k2) -> k2.getValue().compareTo(k1.getValue()))
                                .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));

                        for (Entry<String, Integer> entry : junk.entrySet()) {
                            String key = entry.getKey();
                            Integer value = entry.getValue();
                            System.out.printf("%s: %d\n", key, value);

                        }
                        stop = 0;
                        break;
                    }
                }

                if (material.equals("shards")) {
                    important.put("shards", important.get("shards") + number);
                    if (important.get("shards") >= 250) {
                        System.out.println("\nShadowmourne obtained!");
                        important.put("shards", important.get("shards") - 250);
                        important.entrySet().stream()
                                .sorted((k1, k2) -> k2.getValue().compareTo(k1.getValue()))
                                .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));
                        for (Entry<String, Integer> entry : junk.entrySet()) {
                            String key = entry.getKey();
                            Integer value = entry.getValue();
                            System.out.printf("%s: %d\n", key, value);

                        }
                        stop = 0;
                        break;
                    }
                } else if (!material.equals("motes") && !material.equals("shards") && !material.equals("fragments")) {
                    if (!junk.containsKey(material)) {
                        junk.put(material, number);
                    } else if (junk.containsKey(material)) {
                        junk.put(material, junk.get(material) + number);
                    }

                }
            }
            if (stop == 0) {
                break;
            } else {
                input = scanner.nextLine();
                if (input.length() > 0) {
                    continue;
                }
            }

        }


    }

}
