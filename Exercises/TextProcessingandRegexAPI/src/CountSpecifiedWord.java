import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountSpecifiedWord {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String text = input.nextLine();
		String text1 = input.nextLine();
		String[] stringmasiv = text.split("\\P{Alpha}+");
		int count = 0;
		for (int i = 0; i < stringmasiv.length; i++) {
			if(stringmasiv[i].equalsIgnoreCase(text1)){
				count++;
			}
		}
		System.out.println(count);

	}

}
