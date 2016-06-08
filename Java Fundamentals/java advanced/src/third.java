import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Stack;

public class third {

	public static void main(String[] args) {
		Scanner scanner=  new Scanner(System.in);
		String number = scanner.nextLine();
		ArrayList<Integer> list = new ArrayList<>();
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		for (int i = 0; i < Integer.parseInt(number); i++) {
			String input = scanner.nextLine();
			String[] a = input.split(" ");
			int b = Integer.parseInt(a[0]);
			
			if(b==1){
				int c = Integer.parseInt(a[1]);
				list.add(c);
			}
			else if(b==2){
				if(!list.isEmpty()){
				list.remove(list.size()-1);
				}
			}
			else if(b==3){
				Collections.sort(list);
				System.out.println(list.get(list.size()-1));
			}
			
		}

	}

}
