package february;

import java.util.Scanner;

public class secondmatrix {

	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String[] input = scanner.nextLine().split(" ");
	int row = Integer.parseInt(input[1]);
	int col = Integer.parseInt(input[2]);
	boolean matrix[][] = new boolean[row][col];
	while(!input.equals("Stop")){
		int StartRow =Integer.parseInt(input[0]);
		int WantedRow = Integer.parseInt(input[1]);
		int WantedCol = Integer.parseInt(input[2]);
		
		int stepscounter = 1+Math.abs(WantedRow-StartRow)+WantedCol;
		
		
		
		
		
		
	}
	
	
	}

}
