import java.util.Scanner;

public class HittheTarget {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		
		for (int i = 1; i <= 20; i++) {
			for (int j = 1; j <= 20; j++) {
				if((i+j)==a){System.out.printf("%d + %d \n",i,j);}
			}
		}
		
		for (int i = 20; i > 0; i--) {
			for (int j = 1; j <= 20; j++) {
				if((i-j)==a){System.out.printf("%d - %d \n",i,j);}
			}
		}
	}

}
