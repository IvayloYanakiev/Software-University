package StringandTextProcessing;

import java.util.Scanner;


public class six {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        String searchingword = scanner.nextLine().toLowerCase();

        int count = 0;
        for (int i = 0; i <= input.length()-searchingword.length(); i++) {
            String a = input.substring(i,i+searchingword.length());
            if(a.equals(searchingword)){
                count++;
            }
        }
        System.out.println(count);
    }
}
