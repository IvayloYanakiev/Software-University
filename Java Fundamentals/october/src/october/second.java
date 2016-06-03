package october;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class second {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
	
		 a = a - 1;
	        int charCode = a % 26;

	        char keyLetter = (a / 26) % 2 == 0
	                ? (char)('a' + charCode)
	                : Character.toUpperCase((char)('a' + charCode));

		String key = String.valueOf(keyLetter)+String.valueOf(keyLetter);
		String input = scanner.nextLine();
		StringBuilder sb = new StringBuilder();
		while(!input.equals("End")){
			sb.append(input);
			input = scanner.nextLine();
		}
		String dd = sb.toString();
			String patternn = key + "(.*?)" + key;
			Pattern pattern = Pattern.compile(patternn);
			Matcher matcher = pattern.matcher(dd);
			while (matcher.find()) {
	            if (matcher.group(1).length() > 0) {
	                System.out.println(matcher.group(1));
	            }
	        }
			
	}
	

}
