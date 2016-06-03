package SetsMaps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class fourth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        TreeMap<Character,Integer> map = new TreeMap<>();



            for (int i = 0; i <s.length() ; i++) {


                if(map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i),map.get(s.charAt(i))+1);
                }
                if(!map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i),1);
                }
            }


        for (Map.Entry<Character,Integer> asd : map.entrySet()) {
            Character key = asd.getKey();
            Integer value = asd.getValue();
            System.out.printf("%c: %d time/s",key,value);
            System.out.println();
        }

    }
}



