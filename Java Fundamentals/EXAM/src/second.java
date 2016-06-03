import java.util.Arrays;
import java.util.Scanner;

public class second {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String[] input1 = input.split(" ");
		int rows = Integer.parseInt(input1[0]);
		int cols = Integer.parseInt(input1[1]);
		String matrix[][] = new String[rows][cols];
		int filler = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix[i][j] = String.valueOf(filler);
				filler++;
			}
		}
		String destroy = scanner.nextLine();
		
		while(!destroy.equals("Nuke it from orbit")){
			String[] cellstodestroy = destroy.split(" ");
		
		int rowtodestroy = Integer.parseInt(cellstodestroy[0]);
		int coltodestroy = Integer.parseInt(cellstodestroy[1]);
		int radius = Integer.parseInt(cellstodestroy[2]);
		
		
		try{ 
		//dqsno
		for (int col = coltodestroy; col <= Math.abs(coltodestroy+radius); col++) {
			matrix[rowtodestroy][col] =" ";
			
		}
		
		//nalqvo
		for (int col = coltodestroy; col >= Math.abs(coltodestroy-radius); col--) {
			matrix[rowtodestroy][col] =" ";
			
		}
		
		//nadoly
		for (int j = rowtodestroy; j <= Math.abs(rowtodestroy+radius); j++) {
			
		}
		
		//nagore
		for (int j = rowtodestroy; j >= Math.abs(rowtodestroy-radius); j--) {
			matrix[j][coltodestroy]=" ";
		}
		
		}
		catch(IndexOutOfBoundsException e){}
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(matrix[i][j]+ " ");
			}
			System.out.println();
		}
		
		destroy=scanner.nextLine();
		} 
	}

}
