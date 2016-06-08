package february;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tridesi {

	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String input = scanner.nextLine();
	String number = "";
	HashMap<String,Integer> map = new HashMap<>();
	map.put("aa",0);
	map.put("aba", 1);
	map.put("bcc",2);
	map.put("cc", 3);
	map.put("cdc", 4);
	Pattern pattern = Pattern.compile("(aa|aba|bcc|cc|cdc)");
	Matcher matcher = pattern.matcher(input);
	while(matcher.find()){
		int chislo = map.get(matcher.group());
		number +=chislo;
	}

	BigInteger desi = new BigInteger(number,5);
	
	System.out.println(desi);
	}
	

}
