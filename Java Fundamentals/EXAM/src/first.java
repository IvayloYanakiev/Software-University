import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class first {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String word = scanner.nextLine();
		Pattern pattern = Pattern.compile(word);
		Matcher matcher = pattern.matcher(input);
		
		int index = word.length()/2;
		
		
		
			
		
		for (int i = word.length(); i <=0; i--) {
			
		if(matcher.find()){
			
			input = input.replaceAll(word.toString(), "");
			
			System.out.println("Shaked it.");
	
		}
		StringBuilder sb = new StringBuilder(word);
		sb.deleteCharAt(index);
		word = sb.toString();
		
		
	}
		System.out.println(word);
		System.out.println(input);
	
		
		
		
		
		
		
		
		
	
		

	}

}
