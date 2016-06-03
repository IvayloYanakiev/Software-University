package march;

import java.util.Scanner;

public class monopoly {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] inputarray = input.split(" ");
		
		int hotels = 0;
		int length = Integer.parseInt(inputarray[1]);
		int numberoflines=Integer.parseInt(inputarray[0]);
		int money = 50;
		int moves = 0;
			for (int i = 0; i < numberoflines; i++) {
			
				String choice = sc.nextLine();
				if(i%2==0){
					for (int j = 0; j < choice.length(); j++) {
						
						char choicee=choice.charAt(j);
						switch(choicee){
						
						case 'H' : hotels++; System.out.printf("\nBought a hotel for %d. Total hotels: %d.",money,hotels);
						
							money = 0;
							
							moves++;
							
						break;
						case 'J': System.out.printf("\nGone to jail at turn %d.",moves);
						moves=moves+2;
						money += (hotels * 10) * 2;
						moves++;
						break;
						
						case 'F': moves++; break;
						
						case 'S':
							int moneyToSpend = (i + 1) * (j + 1);
							moneyToSpend = moneyToSpend > money ? money : moneyToSpend;
							money -= moneyToSpend;
							System.out.print(String.format("\nSpent %s money at the shop.", moneyToSpend));
						
						moves++;
						
						break;
					
					}
						
						money += hotels*10;
						
				}
					
					
					
			}
				if(i%2!=0){
					for (int j = choice.length()-1; j >=0 ; j--) {
						
						char choicee=choice.charAt(j);
						switch(choicee){
						
						case 'H' : 
							hotels++; 
							System.out.printf("\nBought a hotel for %d. Total hotels: %d.",money,hotels);
						
							money = 0;
							
							moves++;
							
						break;
						
						case 'J': System.out.printf("\nGone to jail at turn %d.",moves);
						moves=moves+2;
						money += (hotels * 10) * 2;
						moves++;
						break;
						
						case 'F': moves++; break;
						
						case 'S':
							int moneyToSpend = (i + 1) * (j + 1);
							moneyToSpend = moneyToSpend > money ? money : moneyToSpend;
							money -= moneyToSpend;
							System.out.print(String.format("\nSpent %s money at the shop.", moneyToSpend));
						
						
						moves++;
						
						break;
					
					}
						
						money += hotels*10;
						
				}
					
					
					
			}
				

	}
			System.out.printf("\nTurns %d",moves);
			System.out.printf("\nMoney %d",money);

}}
