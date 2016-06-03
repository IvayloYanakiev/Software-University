import java.util.Scanner;

public class Extractwords {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String[] str = input.split("\\P{Alpha}+");
		for (String string : str) {
			System.out.print(string+ " ");
		}

	}

}
