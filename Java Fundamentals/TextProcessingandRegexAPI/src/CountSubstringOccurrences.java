import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountSubstringOccurrences {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String word = scanner.nextLine();
		input = input.toLowerCase();
		word = word.toLowerCase();
		
		Pattern pattern = Pattern.compile(word);
		Matcher matcher = pattern.matcher(input);
		int count = 0;
		while(matcher.find()){
			count++;
		}
		System.out.println(count);

	}

}
