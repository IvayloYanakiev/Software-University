package desisladkata;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class prelestnata {

	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String input = scanner.nextLine();
	 
	 int count = 0;
		while(!input.equals("<stop/>")){
			Pattern pattern = Pattern.compile(".+?(inverse|reverse).+?content.+\"([a-zA-Z0-9\\s:!@#$%^&*]+)\"");
			Matcher matcher = pattern.matcher(input);
			if(matcher.find()){
			   
				if(matcher.group(1).equals("inverse")){
					String inputt = matcher.group(2);
						String sentence="";
					  	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					   
					
					    for(int i=0;i<inputt.length();i++)
					    {
					        if(Character.isUpperCase(inputt.charAt(i))==true)
					        {
					            char ch2= (char)(inputt.charAt(i)+32);
					            sentence = sentence + ch2;
					        }
					        else if(Character.isLowerCase(inputt.charAt(i))==true)
					        {
					            char ch2= (char)(inputt.charAt(i)-32);
					            sentence = sentence + ch2;
					        }
					        else
					        	sentence= sentence + inputt.charAt(i);
					        
					    }
					    count++;
					System.out.printf("%d. %s\n",count,sentence);
				}
				if(matcher.group(1).equals("reverse")){
					
					String inputt  = matcher.group(2);
					StringBuilder sb = new StringBuilder(inputt);
					
					inputt= sb.reverse().toString();
					count++;
					System.out.printf("%d. %s\n",count,inputt);
				}
				
			}
			
			Pattern pattern1 = Pattern.compile(".+\"([0-9]+)\".+\"([\\s+a-zA-Z0-9!@#$%^&*]+)\".+");
			Matcher matcher1 = pattern1.matcher(input);
			if(matcher1.find()){
				
				String inputt  = matcher1.group(2);
				int times = Integer.parseInt(matcher1.group(1).toString());
				for (int i = 0; i < times; i++) {
					count++;
					System.out.printf("%d. %s\n",count,inputt);
				}
				
			}
			input = scanner.nextLine();
		}
	}

}


