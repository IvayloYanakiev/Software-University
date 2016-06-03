package SetsMaps;


import java.util.HashSet;
import java.util.Scanner;

public class second {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] a = input.split(" ");
        for (int i = 0; i < Integer.parseInt( a[0]); i++) {
            set.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < Integer.parseInt( a[1]); i++) {
            set2.add(Integer.parseInt(scanner.nextLine()));
        }
        set.retainAll(set2);
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }
}
