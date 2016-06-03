import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FilterArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String[] array = input.split(" ");
		ArrayList<String> asd = (ArrayList) Arrays.stream(array).filter(str -> str.length()>3).collect(Collectors.toList());
		
	if(asd.isEmpty()==true){ System.out.println("empty");}
	else {for (String string : asd) {
		System.out.print(string+" ");
	}}
		
	}

}
