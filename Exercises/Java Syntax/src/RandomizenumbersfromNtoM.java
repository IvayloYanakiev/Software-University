import java.util.Random;
import java.util.Scanner;

public class RandomizenumbersfromNtoM {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random randomGenerator = new Random();
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		
		int count = 0;
		if(a>b){
			
			int[] num = new int[(a-b)+1];
			
			for(int i=b;i<=a;i++){
				
				num[count]=i;
				count++;
				
			}
			
			System.out.println("random chisla");
			
			for(int i=num.length;i>0;i--){
				int rand=(int) (Math.random()*i);
				int smqna = num[rand];
				num[rand]=num[i-1];
				num[i-1]=smqna;
				System.out.println(num[i-1]);
			}
		}
			if(b>=a){
			
			int[] num = new int[(b-a)+1];
			
			for(int i=a;i<=b;i++){
				
				num[count]=i;
				count++;
				
			}
			System.out.println("random chisla");
			for(int i=num.length;i>0;i--){
				int rand=(int) (Math.random()*i);
				int smqna = num[rand];
				num[rand]=num[i-1];
				num[i-1]=smqna;
				System.out.println(num[i-1]);
			}
		}
		

	}
}
