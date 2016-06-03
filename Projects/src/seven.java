import java.util.Scanner;
import java.util.Stack;

public class seven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        if (balancedParenthensies(a) == true) {
            System.out.println("YES");
        } else System.out.println("NO");
    }

    public static boolean balancedParenthensies(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '(' || c == '{') {

                stack.push(c);

            } else if (c == ']') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != '[') return false;

            } else if (c == ')') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != '(') return false;

            } else if (c == '}') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != '{') return false;
            }

        }
        return stack.isEmpty();
    }
}


