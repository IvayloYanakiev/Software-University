package february;

import java.util.Scanner;

public class second {

	public static void main(String[] args) {
		int moves = 0;
		int isfull = 0;
		Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine();
		String[] input = a.split(" ");
		int row = Integer.parseInt(input[0]);
		int col = Integer.parseInt(input[1]);
		boolean matrix[][] = new boolean[row][col];
		String b = scanner.nextLine();
		while(!b.equals("stop")){
			String[] inputt = b.split(" ");
			int startingrow = Integer.parseInt(inputt[0]);
			int wantedrow = Integer.parseInt(inputt[1]);
			int wantedcol = Integer.parseInt(inputt[2]);
		
			for (int i = 1; i < col; i++) {
				if(matrix[wantedrow][i]==true){
					isfull++;
				}
			}
			if(matrix[wantedrow][wantedcol]==false){
				matrix[wantedrow][wantedcol] = true;
				moves = 1 + Math.abs(wantedrow-startingrow) + wantedcol;
				System.out.println(moves);
				
			}
			else if(matrix[wantedrow][wantedcol]==true){
				for (int i = wantedcol-1 ; i>=1 ; i--) {
					if(matrix[wantedrow][i]==false){
						matrix[wantedrow][i] = true;
						moves = 1 + Math.abs(wantedrow-startingrow) + i;
						System.out.println(moves);
						
					}
					else { for (int j = wantedcol+1; j < col; j++) {
						if(matrix[wantedrow][j]==false){
							matrix[wantedrow][j] = true;
							moves = 1 + Math.abs(wantedrow-startingrow) + j;
							System.out.println(moves);
						
						}
					}}
					
					
					
				}
				
				if(isfull==col-1){System.out.printf("Row %d full",wantedrow);}
			}
			
			
			
			
			
			 b = scanner.nextLine();
			
		}
		
	}

}
