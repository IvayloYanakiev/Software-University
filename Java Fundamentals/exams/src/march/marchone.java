package march;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class marchone {

	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	String input = scanner.nextLine();
	String[] arrayofinput = input.split(",\\s+");
	HashMap<Character,String> numbertostring = new HashMap<Character,String>();
	ArrayList<String> sortirane = new ArrayList<>();
	numbertostring.put('0', "zero");
	numbertostring.put('1', "one");
	numbertostring.put('2', "two");
	numbertostring.put('3', "three");
	numbertostring.put('4', "four");
	numbertostring.put('5', "five");
	numbertostring.put('6', "six");
	numbertostring.put('7', "seven");
	numbertostring.put('8', "eight");
	numbertostring.put('9', "nine");
	
	for (String string : arrayofinput) {
		StringBuilder sb = new StringBuilder();
		for (char digit : string.toCharArray()) {
		sb.append(numbertostring.get(digit));
		
		
			
		}
		
		
		
		sortirane.add(sb.toString());
		
	}
	Collections.sort(sortirane);
	
	
	
	HashMap<String,Character> stringtonumber = new HashMap<>();
	stringtonumber.put("zero",'0');
	stringtonumber.put("one",'1');
	stringtonumber.put("two",'2');
	stringtonumber.put("three",'3');
	stringtonumber.put("four",'4');
	stringtonumber.put("five",'5');
	stringtonumber.put("six",'6');
	stringtonumber.put("seven",'7');
	stringtonumber.put("eight",'8');
	stringtonumber.put("nine",'9');
	
	for (Iterator<String> iterator = sortirane.iterator() ; iterator.hasNext();) {
		
	
	String string1 = iterator.next();
		String result = string1;
		
		for (String number : stringtonumber.keySet()) {
			
			result = result.replaceAll(number,stringtonumber.get(number) + "");
			
		}
		
		if(iterator.hasNext()){
			System.out.print(result + ", ");
		}
		else{ System.out.println(result);
		
		}
	}
	
	}

	}

