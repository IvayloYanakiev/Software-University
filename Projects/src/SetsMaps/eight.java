package SetsMaps;


import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class eight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        Pattern pattern = Pattern.compile("([a-zA-Z !@#$%^&*()-_+=<>]+):\\s?(.+)");

        while (!input.equals("JOKER")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group(1);
                String cards = matcher.group(2);
                if (!map.containsKey(name)) {
                    String asd = "";
                    map.put(name, asd);
                }
                String cards1 = map.get(name) +" "+ cards;

                map.put(name,  cards1.replaceAll(","," "));

            }
            input = scanner.nextLine();

        }

        for (String s : map.keySet()) {
            Integer smetka = 0;
            String cards = map.get(s);
            LinkedHashSet<String> set = new LinkedHashSet<>();
            Pattern pattern1 = Pattern.compile("([a-zA-Z0-9]+)");
            Matcher matcher1 = pattern1.matcher(cards);
            while(matcher1.find()){
                set.add(matcher1.group(1));
            }
            for (String s1 : set) {
                Pattern pattern2 = Pattern.compile("([0-9A-Z]+)([A-Z])");
                Matcher matcher3 = pattern2.matcher(s1);
                if(matcher3.find()){
                    String bonus = matcher3.group(2);
                    String card = matcher3.group(1);
                    Integer bonuss = 0;
                    Integer cardpoints=0;

                    if (bonus.equals("S")) {
                        bonuss = 4;
                    } else if (bonus.equals("H")) {
                        bonuss = 3;
                    } else if (bonus.equals("D")) {
                        bonuss = 2;
                    } else if (bonus.equals("C")) {
                        bonuss = 1;
                    }


                    switch (card) {
                        case "J":
                            cardpoints =11;
                            break;
                        case "Q":
                            cardpoints =12;
                            break;
                        case "K":
                            cardpoints =13;
                            break;
                        case "A":
                            cardpoints =14;
                            break;
                        case "2":
                            cardpoints =2;
                            break;
                        case "3":
                            cardpoints =3;
                            break;
                        case "4":
                            cardpoints =4;
                            break;
                        case "5":
                            cardpoints =5;
                            break;
                        case "6":
                            cardpoints =6;
                            break;
                        case "7":
                            cardpoints =7;
                            break;
                        case "8":
                            cardpoints =8;
                            break;
                        case "9":
                            cardpoints =9;
                            break;
                        case "10":
                            cardpoints =10;
                            break;

                    }

            smetka  += cardpoints*bonuss;
                }
            }

    System.out.printf("%s: %d\n",s,smetka);
        }
    }
}
