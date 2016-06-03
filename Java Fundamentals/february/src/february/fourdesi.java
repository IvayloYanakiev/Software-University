package february;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class fourdesi {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int howmanytimes = Integer.parseInt(scanner.nextLine());
		HashMap<String,HashMap<String,String>> map = new HashMap<>();
		HashMap<String,String> map1 = new HashMap<>();
		
		for (int i = 0; i < howmanytimes; i++) {
			
			String input = scanner.nextLine();
			Pattern pattern = Pattern.compile("#([a-zA-Z]+).+?([a-zA-Z]+).+?([0-9]+):([0-9]+)");
			Matcher matcher = pattern.matcher(input);
			
			
			System.out.println();
			
		}

	}

}
