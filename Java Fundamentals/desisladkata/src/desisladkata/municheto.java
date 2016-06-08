package desisladkata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class municheto {

	public static void main(String[] args) {
	
	Scanner scanner = new Scanner(System.in);
	String[] input = scanner.nextLine().split(",?\\s+?");
	HashMap<Character,String> map = new HashMap<>();
	ArrayList<String> array = new ArrayList<>();
	map.put('0', "zero");
	map.put('1', "one");
	map.put('2', "two");
	map.put('3', "three");
	map.put('4', "four");
	map.put('5', "five");
	map.put('6', "six");
	map.put('7', "seven");
	map.put('8', "eight");
	map.put('9', "nine");

	for (String string	 : input) {
		StringBuilder sb = new StringBuilder();
		for (Character chara : string.toCharArray()) {
		sb.append(map.get(chara));
		}
		array.add(sb.toString());
	}
	Collections.sort(array);

	
	LinkedHashMap<String,Integer> mapa = new LinkedHashMap<String,Integer>();
	mapa.put("zero",0);
	mapa.put("one", 1);
	mapa.put("two", 2);
	mapa.put("three", 3);
	mapa.put("four", 4);
	mapa.put("five", 5);
	mapa.put("six", 6);
	mapa.put("seven", 7);
	mapa.put("eight", 8);
	mapa.put("nine", 9);
	
	ArrayList<String> sklad = new ArrayList<>();
	
	
for (String string : array) {
	StringBuilder sb1 = new StringBuilder();
	Pattern pattern = Pattern.compile("zero|one|two|three|four|five|six|seven|eight|nine");
	Matcher matcher = pattern.matcher(string);
	
	
	while(matcher.find())
	{	
		sb1.append(mapa.get(matcher.group()));
	}	
	sklad.add(sb1.toString());
	
}
Iterator itr = sklad.iterator();
String finall="";
for (String string : sklad) {
	if(itr.hasNext()){
		finall +=string + ", ";
	}
	
}
StringBuilder b = new StringBuilder(finall);
b.replace(finall.lastIndexOf(", "), finall.lastIndexOf(", ") + 1, "" );
finall = b.toString();
System.out.println(finall);



	}

}
