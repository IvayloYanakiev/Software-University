package february;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class asdasd {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputmatrix = scanner.nextLine();
		inputmatrix.trim();
		String[] razmeri = inputmatrix.split(" ");
		
		int row = Integer.parseInt(razmeri[0]);
		int col = Integer.parseInt(razmeri[1]);
		System.out.println(row + col);
	}

}
