import java.util.Scanner;

public class Calculateexpression {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		float a = scanner.nextFloat();
		float b = scanner.nextFloat();
		float c = scanner.nextFloat();
		
		float f1 = (float) Math.pow(((a*a + b*b)/(a*a - b*b)),((a + b + c)/Math.sqrt(c)));
		float f2 = (float)Math.pow((a*a + b*b - c*c*c), a-b);
		
		float averagenumbers = (a+b+c)/3;
		float averageformulas = (f1+f2)/2;
		
		float difference = Math.abs(averagenumbers - averageformulas);
		
		System.out.printf("F1:%.2f;   F2:%.2f;    Difference:%.2f",f1,f2,difference);
	
	}

}
