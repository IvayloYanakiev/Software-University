package SetsMaps;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class fifth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayList<String> array = new ArrayList<>();
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        while (!input.equals("search")) {
            String[] a = input.split("-");
            map.put(a[0], a[1]);
            input = scanner.nextLine();


        }
        input = scanner.nextLine();
        while (!input.equals("stop")) {
            if (map.containsKey(input)) {
                System.out.printf("%s -> %s", input, map.get(input));
                System.out.println();
            } else {
                System.out.printf("Contact %s does not exist.", input);
                System.out.println();
            }
            input = scanner.nextLine();
        }


    }
}
