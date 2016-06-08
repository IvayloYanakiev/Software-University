import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class second {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine();
		String[] b = a.split(" ");
		Stack<Integer> stack = new Stack<>();
		int numbers = Integer.parseInt(b[0]);
		int s = Integer.parseInt(b[1]);
		int x = Integer.parseInt(b[2]);
		for (int i = 0; i < numbers; i++) {
			stack.push(scanner.nextInt());
		}
		ArrayList<Integer> list = new ArrayList<>();
		int min = 0;
		
		boolean checker = false;
		for (int i = 0; i < s; i++) {
			stack.pop();
		}
		
		System.out.println();
		
		while(!stack.isEmpty()){
			int dd = stack.pop();
			if(dd==x){
				checker = true;
				System.out.println(checker);
			}
			else if(dd!=x){
				
			list.add(dd);
			}
			
				
		}
		if(checker==false && !list.isEmpty()){
			Collections.sort(list);
				System.out.println(list.get(0));
		}
		if(list.isEmpty()){
			System.out.println("0");
		}
			
			
		}
		
		
		

	}


