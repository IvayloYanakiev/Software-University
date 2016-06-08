package SetsMaps;


        import java.util.HashSet;
        import java.util.LinkedHashSet;
        import java.util.Scanner;


public class first {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();

        LinkedHashSet<String> set = new LinkedHashSet<>();

        for(int i = 0 ; i<Integer.parseInt(number);i++){
            String input = scanner.nextLine();
            set.add(input);
        }
        for (String s : set) {
            System.out.println(s);
        }
        scanner.close();

    }
}
