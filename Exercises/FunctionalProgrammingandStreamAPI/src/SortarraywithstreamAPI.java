import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortarraywithstreamAPI {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String bsa = scanner.nextLine();
		String[] array = input.split(" ");
        ArrayList<String> asd = (ArrayList<String>) Arrays.stream(array).sorted().collect(Collectors.toList());
	
        if(bsa.equals("Ascending")){
        	for (String string : asd) {
    		System.out.print(string+" ");
    		}
        }
        else if(bsa.equals("Descending")){
        	for (int i = array.length-1; i >= 0; i--) {
				System.out.println(asd.get(i));
			}
        }
    	
	
	}

}
