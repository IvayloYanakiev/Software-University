import java.util.Scanner;

public class StartsandEndsWithCapitalLetter {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String[] str = input.split(" ");
		

		for (int i = 0; i < str.length; i++) {
			if(Character.isUpperCase(str[i].charAt(0)) && Character.isUpperCase(str[i].charAt(str[i].length()-1))){
				
				if(str[i].matches("[^a-zA-Z].*$^.*")){
					continue;
				}
				else{
					System.out.print(str[i] + " ");
				}
				
			
				}
			}
		}
	}


