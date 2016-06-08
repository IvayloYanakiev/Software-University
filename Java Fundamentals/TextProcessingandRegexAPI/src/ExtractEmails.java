import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		

		Pattern pattern = Pattern.compile("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b");
		Matcher matcher = pattern.matcher(input);
		
		while(matcher.find()){
			  String b = matcher.group();
              String c = b.toString() + ".*";
              System.out.println(c);
		}
		
	}
}
