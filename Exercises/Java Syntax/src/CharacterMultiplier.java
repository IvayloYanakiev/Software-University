import java.util.Scanner;

public class CharacterMultiplier {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("Vuvedi dvata stringa sus space :");
		
		String string = scanner.nextLine();
		String[] string1 = string.split(" ");
		String one = string1[0];
		String two = string1[1];
		int sum =0;
		
		if(one.length()==two.length()){
			for (int i = 0; i < one.length(); i++) {
				char character = one.charAt(i);
				char character1 = two.charAt(i);
				int ascii = (int) character; 
				int ascii1 = (int) character1; 
				sum += ascii*ascii1;
			
			
			}
		System.out.println(sum);
		}
		
		else if (one.length()!=two.length()){
			
			if(one.length()>two.length()){
				
				for (int i = 0; i < two.length(); i++) {
					char character = one.charAt(i);
					char character1 = two.charAt(i);
					int ascii = (int) character; 
					int ascii1 = (int) character1; 
					sum += ascii*ascii1;
				
				}
				for(int left=two.length();left<one.length();left++){
					char character = one.charAt(left);
					int ascii = (int) character; 
					sum=ascii+sum;
				}
				System.out.println(sum);
				
			}
			
			if(two.length()>one.length()){
				
				for (int i = 0; i < one.length(); i++) {
					char character = one.charAt(i);
					char character1 = two.charAt(i);
					int ascii = (int) character; 
					int ascii1 = (int) character1; 
					sum += ascii*ascii1;
				
				}
				for(int left=one.length();left<two.length();left++){
					char character = two.charAt(left);
					int ascii = (int) character; 
					sum=ascii+sum;
				}
				System.out.println(sum);
				
			}
		}
		
		
	}

}
