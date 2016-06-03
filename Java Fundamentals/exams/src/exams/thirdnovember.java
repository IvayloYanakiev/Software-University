package exams;

import java.util.Scanner;

public class thirdnovember {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		int counter = 1;
		int count =0;
	
		
		String[] inputt=input.split(" ");
		int rows = Integer.parseInt(inputt[0]);
		int cols = Integer.parseInt(inputt[1]);
		int matrix[][]=new int[rows][cols];
	
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix[i][j]=counter;
				
				
				counter++;
			}
		}
		 int number = Integer.parseInt(sc.nextLine());
		 for (int i = 0; i < number;number++) {
			String[] stringinput = sc.nextLine().split(" ");
			int whichline = Integer.parseInt(stringinput[0]);
			int steps = Integer.parseInt(stringinput[2]);
			String choice = stringinput[1];
			switch(choice){
				case "left" :
					moveRow(matrix, whichline, steps, cols);
					//int firstindex = matrix[whichline][0];
					
					//for (int j = 0; j < cols-1; j++) {
						
						//matrix[whichline][j]=matrix[whichline][(j+steps)%cols];
						
					//}
					//matrix[whichline][cols-1]=firstindex;
					
				for (int j = 0; j < rows; j++) {
					for (int j2 = 0; j2 < cols; j2++) {
						System.out.print(matrix[j][j2]+ " ");
					}
					System.out.println();
				}
					break;
				case "right" : 
					int lastindex = matrix[whichline][cols-1];
					
					for (int j = cols-1; j >0; j--) {
						
						matrix[whichline][j]=matrix[whichline][j-1];
						
					}
					matrix[whichline][0]=lastindex;
				for (int j = 0; j < rows; j++) {
					for (int j2 = 0; j2 < cols; j2++) {
						System.out.print(matrix[j][j2]);
					}
					System.out.println();
				}
				
					break;
				case "up" :
					int first = matrix[0][whichline];
					
					
					for (int j = 0; j < rows-1; j++) {
						matrix[j][whichline]=matrix[j+1][whichline];
					}
					matrix[rows-1][whichline]=first;
					
					for (int j = 0; j < rows; j++) {
						for (int j2 = 0; j2 < cols; j2++) {
							System.out.print(matrix[j][j2]);
						}
						System.out.println();
					}
					
					break;
				case "down" :
					int lastindexx = matrix[rows-1][whichline];
					
					for (int row=rows-1;row>0;row--) {
						
						matrix[row][whichline]=matrix[row-1][whichline];
						
					}
					matrix[0][whichline]=lastindexx;
					
					for (int j = 0; j < rows; j++) {
						for (int j2 = 0; j2 < cols; j2++) {
							System.out.print(matrix[j][j2]);
						}
						System.out.println();
					}
					break;
			}
		}
		
	}
	 private static void moveRow(int[][] matrix, int row, int moves, int cols) {
	        int[] tempArr = new int[cols];
	        for (int index = 0; index < cols; index++) {
	            tempArr[index] = matrix[row][(index + moves) % cols];
	        }

	        System.arraycopy(tempArr, 0, matrix[row], 0, tempArr.length);
	    }

}
