import java.util.Scanner;

public class TriangleArea {

	public static void main(String[] args) {
		System.out.println("Write coordinates for a");
		Scanner scanner = new Scanner(System.in);
		int a=scanner.nextInt();
		int a1=scanner.nextInt();
	
		System.out.println("Write coordinates for b");
		int b=scanner.nextInt();
		int b1=scanner.nextInt();
		
		System.out.println("Write coordinates for c");
		int c=scanner.nextInt();
		int c1=scanner.nextInt();
		
		int area = Math.abs((a*(b1-c1)+ b*(c1-a1) + c*(a1-b1))/2);
		System.out.printf("The triangle area is : %d ",area);
		if (area == 0){
			System.out.println("Not right");
		}

		
	}

	

}
