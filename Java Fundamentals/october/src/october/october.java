package october;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class october {

	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String input = scanner.nextLine();
	int glowcaps = 0;
	int damage = 0;
	String stop = "";
	int health = 5800;
	while(!input.equals("Sporeggar"))	{
		
		for (int i = 0; i < input.length()-1; i++) {
			if(input.charAt(i)=='L'){
				health +=200;
			}
			else{
			damage = (int) input.charAt(i);
			health = health - damage;
			}
			
		}
		if(health<=0){
			System.out.printf("\nDied. Glowcaps: %d",glowcaps);
			stop = "Died";
			break;
		}
		
		Pattern pattern = Pattern.compile("[!@#$%^&*()_ -+=?><0-9a-zA-z]+([0-9])");
		Matcher matcher = pattern.matcher(input);
		if(matcher.find()){
			glowcaps +=Integer.parseInt(matcher.group(1).toString());
			
		}
		input = scanner.nextLine();
	}
	if(!stop.equals("Died")){
	if(glowcaps>=30){
		System.out.printf("Health left: %d\n",health);
		System.out.printf("Bought the sporebat. Glowcaps left: %d",(glowcaps-30));
	}
	else if(glowcaps<30){
		System.out.printf("Health left: %d\n",health);
		System.out.printf("Safe in Sporeggar, but another %d Glowcaps needed.",(30-glowcaps));
	}
	}
	}

}

