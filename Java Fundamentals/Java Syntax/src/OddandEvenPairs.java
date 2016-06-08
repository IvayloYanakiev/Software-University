import java.util.Scanner;

public class OddandEvenPairs {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Vuvedi chislata sus space :");
		
		String numbers = scanner.nextLine();
		String[] numbersArray = numbers.split(" ");
		
		int b=0;
		int c=1;
		
		
			if(numbersArray.length%2==0){
			
			
			while(b< numbersArray.length-1 && c< numbersArray.length){
				int d = Integer.parseInt(numbersArray[b]);
				int f = Integer.parseInt(numbersArray[c]);
				if(d%2==0 && f%2==0){System.out.printf("%d and %d -> both are even \n",d,f);}
				if(d%2!=0 && f%2!=0){System.out.printf("%d and %d -> both are odd\n",d,f);}
				if((d%2!=0 && f%2==0) || (d%2==0 && f%2!=0)){System.out.printf("%d and %d -> different\n",d,f);}
				b=b+2;
				c=c+2;
			}
			
			
		}
		
		
		
		
		
		
			
			
				
				
				
				
		
				
			
			
		
	if(numbersArray.length%2!=0) { System.out.println("Invalid length");
	
	
	}

	}}
