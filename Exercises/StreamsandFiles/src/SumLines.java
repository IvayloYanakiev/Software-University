import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class SumLines {

	public static void main(String[] args) {
		try{
		
		BufferedReader chetec = new BufferedReader(new FileReader("lines.txt"));
		String line = chetec.readLine();
		
		while(line!=null){
			int sum =0;	
		for (int i = 0; i < line.length(); i++) {
			
			char a = line.charAt(i);
			int asci = (int) a;
			sum +=asci;
			
		}
		System.out.println(sum);
		
		line = chetec.readLine();
		
		}
		chetec.close();
		}
		
		catch(FileNotFoundException e){
			System.out.println(e);
		}
		catch(Exception d){
			System.out.println(d);
		}
		
	}

}
