import java.util.Scanner;

public class Convertfrombase7todecimal {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine();
				System.out.println(Integer.toString(Integer.parseInt(a, 7), 10));

	}

}
