import java.util.Scanner;

public class FormattingNumbers {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		if(a>=500 || a<=0)
		{
			System.out.println("error");
		}
		float b = scanner.nextFloat();
		
		float c = scanner.nextFloat();
		
		String hexa = String.format("%X", a);
		String binary = String.format("%10s", Integer.toBinaryString(a)).replace(" ", "0");
		
		System.out.printf("|%s        |%s        |      %.2f|%.3f      |",hexa,binary,b,c);
		
	}

}
