package exams;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.sun.org.apache.xerces.internal.impl.xs.identity.Selector.Matcher;

public class secondnovember {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		double softunilitri = 0;
		
		
		
		while(!input.equals("OK KoftiShans")){
				
				Pattern everything = Pattern.compile("([A-Z][a-z]+).*?([A-Z][a-z]*[A-Z]).*?(\\d+)L");
				java.util.regex.Matcher everythingmatcher = everything.matcher(input);
				
				
				while(everythingmatcher.find()){
				    String name = everythingmatcher.group(1);
				    String piene = everythingmatcher.group(2).toLowerCase();
					String litri = everythingmatcher.group(3).toString();
					int litri1 = Integer.parseInt(litri);
					
					softunilitri+=litri1*0.001;
					System.out.printf("\n%s brought %d liters of %s!",name,litri1,piene);
					
					}
				input = scanner.nextLine();
				}
				
				
				
				System.out.printf("\n%.3f softuni liters",softunilitri);
				
			}
			
			
			
			
			
	}




