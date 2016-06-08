import java.util.Scanner;

public class GetFirstOddorEvenElements {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Vuvedi chislata sus space :");
		
		String numbers = scanner.nextLine();
		String[] numbersArray = numbers.split(" ");
		
		System.out.println("Vuvedi Get <number> <odd/even>:\n Primer: Get 4 odd");
		
		String string = scanner.nextLine();
		
		
		String[] string1 = string.split(" ");
		
		int chislo = Integer.parseInt(string1[1]);
		

		if(string1[2].equals("even")){
			if(chislo>numbersArray.length){
				for (int i = 0; i < numbersArray.length; i++) {
					int number = Integer.parseInt(numbersArray[i]);
					if (number%2==0) {
						System.out.println(number);
					}
				}	
			
			}
			int count=0;
			
			if(numbersArray.length>chislo){
				
					for (int i = 0; i < numbersArray.length; i++) {
						int number = Integer.parseInt(numbersArray[i]);
							if (number%2==0) {
								System.out.println(number);
								count++;
								if(count==chislo){break;}
							}
					}	
			
					
			}
		}
		if(string1[2].equals("odd")){
			if(chislo>numbersArray.length){
				for (int i = 0; i < numbersArray.length; i++) {
					int number = Integer.parseInt(numbersArray[i]);
					if (number%2!=0) {
						System.out.println(number);
					}
				}	
			
			}
			int count=0;
			
			if(numbersArray.length>chislo){
				
					for (int i = 0; i < numbersArray.length; i++) {
						int number = Integer.parseInt(numbersArray[i]);
							if (number%2!=0) {
								System.out.println(number);
								count++;
								if(count==chislo){break;}
							}
					}	
			
					
			}
		}
	}
}
