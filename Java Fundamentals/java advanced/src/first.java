import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;import org.omg.Messaging.SyncScopeHelper;

public class first {

	public static void main(String[] args) {
	
		
	Scanner scanner = new Scanner(System.in);
	String a = scanner.nextLine();
	String[] b = a.split(" ");
	Stack<Integer> asd = new Stack<>();
	Stack<Integer> asd1 = new Stack<>();
	for (String string : b) {
		asd.push(Integer.parseInt(string));
	}
	
	while(!asd.isEmpty()){
		asd1.push(asd.pop());
	}
	
	
	asd1.stream().forEach(y -> System.out.print(y+ " "));

	}

}
