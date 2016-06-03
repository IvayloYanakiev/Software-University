package exam;

import java.math.BigDecimal;
import java.util.Scanner;

public class second {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputmatrix = scanner.nextLine();
		
		int count = 0;
		BigDecimal price = new BigDecimal(0);
		String[] razmeri = inputmatrix.split(" ");
		
		int row = Integer.parseInt(razmeri[0]);
		int col = Integer.parseInt(razmeri[1]);
		char matrix[][] = new char[row][col];
		for (int i = 0; i < row; i++) {
			if(i%2==0){
				for (int j = 0; j < col; j++) {
					matrix[i][j] = 'L';
				}
			}
			else if(i%2!=0){
				for (int j = 0; j < col; j++) {
					matrix[i][j] = 'R';
				}
			}
		}
		matrix[0][0] = 'D';
		String[] prices = scanner.nextLine().split(" ");
		double lukanka = Double.parseDouble(prices[0]);
		double rakiya = Double.parseDouble(prices[1]);
		
		String position = scanner.nextLine();
	
		
		
		while(!position.equals("Royal Close")){
			
			String[] a = position.split(" ");
		
			
			int wantedrow = Integer.parseInt(a[0]);
			int wantedcol = Integer.parseInt(a[1]);
		if(wantedrow<row && wantedcol<col){
					if(wantedrow>=wantedcol){
						if(wantedcol!=0){
						for (int i = wantedcol; i > 0; i--) {
							if(matrix[wantedrow][i]=='L'){
								
								price = price.add(new BigDecimal(((wantedrow+1)*(i+1))*lukanka));
								
							}
							if(matrix[wantedrow][i]=='R'){
							
								price = price.add(new BigDecimal(((wantedrow+1)*(i+1))*rakiya));
							
							}
						}}
						for (int j = wantedrow; j > 0; j--) {
						if(matrix[j][0]=='L'){
							
							price = price.add(new BigDecimal((1*(j+1))*lukanka));
								
							}
							if(matrix[j][0]=='R'){
								
								price = price.add(new BigDecimal((1*(1+j))*rakiya));
								
							}
						}
						
					}
					else if(wantedrow<wantedcol){
						if(wantedrow!=0){
						for (int b = wantedrow; b >0; b--) {
							if(matrix[b][wantedcol]=='L'){
							
								price = price.add(new BigDecimal(((wantedcol+1)*(b+1))*lukanka));
									
								}
								if(matrix[b][wantedcol]=='R'){
							
									price = price.add(new BigDecimal(((wantedcol+1)*(b+1))*rakiya));

									
								}
							}}
						for (int i = wantedcol; i > 0; i--) {
							if(matrix[0][i]=='L'){
								
								price = price.add(new BigDecimal((1*(i+1))*lukanka));

							
							}
							if(matrix[0][i]=='R'){
								
								price = price.add(new BigDecimal((1*(i+1))*rakiya));

								
							}
						}
						
					}
			count++;
			
		
			position = scanner.nextLine();
			
		}
		else System.exit(0);;
			
			}
		
		System.out.printf("%.6f \n",price);
		System.out.println(count);
		if(count>1000) { System.exit(1);}
	}

}
