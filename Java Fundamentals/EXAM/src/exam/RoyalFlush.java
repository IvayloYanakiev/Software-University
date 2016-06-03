package exam;
 
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
 
public class RoyalFlush {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = Integer.parseInt(sc.nextLine());
 
        Hashtable<Character, ArrayList<String>> hashTable = new Hashtable<>();
        hashTable.put('c', new ArrayList());
        hashTable.put('d', new ArrayList<>());
        hashTable.put('h', new ArrayList<>());
        hashTable.put('s', new ArrayList<>());
 
        Integer royalFlushCounter = 0;
        int offset = 0;
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            offset = 0;
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == 's' || line.charAt(j) == 'd' || line.charAt(j) == 'c' || line.charAt(j) == 'h') {
                    String str = line.substring(offset, j);
                    switch (str) {
                    case "10":
                        if (hashTable.get(line.charAt(j)).contains("10") || hashTable.get(line.charAt(j)).contains("J")
                                || hashTable.get(line.charAt(j)).contains("Q")
                                || hashTable.get(line.charAt(j)).contains("K")
                                || hashTable.get(line.charAt(j)).contains("A")) {
                            hashTable.get(line.charAt(j)).remove("J");
                            hashTable.get(line.charAt(j)).remove("Q");
                            hashTable.get(line.charAt(j)).remove("K");
                            hashTable.get(line.charAt(j)).remove("A");
                        }
                        break;
                    case "J":
                        if (hashTable.get(line.charAt(j)).contains("J") || hashTable.get(line.charAt(j)).contains("Q")
                                || hashTable.get(line.charAt(j)).contains("K")
                                || hashTable.get(line.charAt(j)).contains("A")) {
                            hashTable.get(line.charAt(j)).remove("10");
                            hashTable.get(line.charAt(j)).remove("J");
                            hashTable.get(line.charAt(j)).remove("Q");
                            hashTable.get(line.charAt(j)).remove("K");
                            hashTable.get(line.charAt(j)).remove("A");
                        }
                        break;
                    case "Q":
                        if (hashTable.get(line.charAt(j)).contains("Q") || hashTable.get(line.charAt(j)).contains("K")
                                || hashTable.get(line.charAt(j)).contains("A")) {
                            hashTable.get(line.charAt(j)).remove("10");
                            hashTable.get(line.charAt(j)).remove("J");
                            hashTable.get(line.charAt(j)).remove("Q");
                            hashTable.get(line.charAt(j)).remove("K");
                            hashTable.get(line.charAt(j)).remove("A");
                        }
                        break;
                    case "K":
                        if (hashTable.get(line.charAt(j)).contains("K")
                                || hashTable.get(line.charAt(j)).contains("A")) {
                            hashTable.get(line.charAt(j)).remove("10");
                            hashTable.get(line.charAt(j)).remove("J");
                            hashTable.get(line.charAt(j)).remove("Q");
                            hashTable.get(line.charAt(j)).remove("K");
                            hashTable.get(line.charAt(j)).remove("A");
                        }
                        break;
                    case "A":
                        if (hashTable.get(line.charAt(j)).contains("A")) {
                            hashTable.get(line.charAt(j)).remove("10");
                            hashTable.get(line.charAt(j)).remove("J");
                            hashTable.get(line.charAt(j)).remove("Q");
                            hashTable.get(line.charAt(j)).remove("K");
                            hashTable.get(line.charAt(j)).remove("A");
                        }
                        break;
                    }
 
                    switch (line.charAt(j)) {
                    case 'c':
                        hashTable.get('c').add(str);
                        break;
                    case 'd':
                        hashTable.get('d').add(str);
                        break;
                    case 's':
                        hashTable.get('s').add(str);
                        break;
                    case 'h':
                        hashTable.get('h').add(str);
                        break;
                    }
                   
                    offset = j + 1;
 
                    if (hashTable.get(line.charAt(j)).contains("10") && hashTable.get(line.charAt(j)).contains("J")
                            && hashTable.get(line.charAt(j)).contains("Q")
                            && hashTable.get(line.charAt(j)).contains("K")
                            && hashTable.get(line.charAt(j)).contains("A")) {
 
                        switch (line.charAt(j)) {
                        case 'c':
                            System.out.println("Royal Flush Found - Clubs");
                            break;
                        case 'd':
                            System.out.println("Royal Flush Found - Diamonds");
                            break;
                        case 'h':
                            System.out.println("Royal Flush Found - Hearts");
                            break;
                        case 's':
                            System.out.println("Royal Flush Found - Spades");
                            break;
                        }
 
                        hashTable.get(line.charAt(j)).remove("10");
                        hashTable.get(line.charAt(j)).remove("J");
                        hashTable.get(line.charAt(j)).remove("Q");
                        hashTable.get(line.charAt(j)).remove("K");
                        hashTable.get(line.charAt(j)).remove("A");
 
                        royalFlushCounter++;
                    }
                }
            }
        }
 
        System.out.printf("Royal's Royal Flushes - %d.", royalFlushCounter);
    }
}