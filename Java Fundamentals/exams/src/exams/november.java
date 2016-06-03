package exams;


import java.util.Scanner;

public class november {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int people =  scanner.nextInt();
		scanner.nextLine();
		int lines = scanner.nextInt();
		scanner.nextLine();
		int food=0;
		int beds = 0;
		if(lines>=1 && lines<=20){
			for (int i = 0; i < lines; i++) {
		
		    String choice = scanner.nextLine();
			
			String choice1[] = choice.split(" ");

			int number = Integer.parseInt(choice1[1]);
			
			if(choice1[0].equals("tents")){
				if(choice1[2].equals("firstClass")){
					beds+=3*number;
				}
				else if(choice1[2].equals("normal")){
					beds+=2*number;
				}
			}
			if(choice1[0].equals("rooms")){
				if(choice1[2].equals("single")){
					beds+=1*number;
				}
				else if(choice1[2].equals("double")){
					beds+=2*number;
				}
				else if(choice1[2].equals("triple")){
					beds+=3*number;
				}
				
			}
			if(choice1[0].equals("food")){
				
				
				if(choice1[2].equals("musaka")){
					food +=2*number;
				}
				else if(choice1[2].equals("zakuska")){
					food +=0;
				}
				
			}
			
		}}
		
		if(beds>=people){
			int bedsleft = beds - people;
			System.out.printf("Everyone is happy and sleeping well. Beds left: %d\n",bedsleft);
		}
		else if(people>beds){
			int bedsneeded = people-beds ;
			System.out.printf("Some people are freezing cold. Beds needed: %d\n",bedsneeded);
		}
		if(food>=people){
			int mealsleft = food-people;
			System.out.printf("Nobody left hungry. Meals left: %d",mealsleft);
		}
		else if(food<people){
			int mealsneeded = people-food;
			System.out.printf("People are starving. Meals needed: %d",mealsneeded);
		}
	

	}

}
