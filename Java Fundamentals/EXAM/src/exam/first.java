package exam;

import java.util.ArrayList;
import java.util.Scanner;

public class first {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		int sum = 0;
		ArrayList<String> array = new ArrayList<>();
		ArrayList<String> array2 = new ArrayList<>();
		int royalists = 0;
		int notroyalists = 0;
		String[] strings = input.split(" ");
		for (int i = 0; i < strings.length; i++) {
			String a= strings[i];
			for (int j = 0; j < a.length(); j++) {
				int ascii = (int) a.charAt(j);
				sum+=ascii;
				while(sum>26){
					sum = sum-26;
				}
				
			
			
			}
			if(sum == 18){
				royalists++;
				array.add(strings[i]);
			}
			else if (sum!=18){ notroyalists++; array2.add(strings[i]);}
			sum=0;
		}
		if(royalists>=notroyalists){
			System.out.printf("Royalists - %d\n",royalists);
			for (String string : array) {
				System.out.println(string);
				
			}
			System.out.println("All hail Royal!");
		}
		if(notroyalists>royalists){
		
			for (String string : array2) {
				System.out.println(string);
				
			}
			System.out.println("Royalism, Declined!");
		}
		
		

	}

}
