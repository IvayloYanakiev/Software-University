import java.util.Scanner;

public class CountAllWords {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String text = input.nextLine();
		String[] stringmasiv = text.split("\\P{Alpha}+");
		
		System.out.println(stringmasiv.length);


	}

}
