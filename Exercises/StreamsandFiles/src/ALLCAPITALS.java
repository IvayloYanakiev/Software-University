import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ALLCAPITALS {

	public static void main(String[] args) {
		try{
			
			BufferedReader chetec = new BufferedReader(new FileReader("lines.txt"));
			String line = chetec.readLine();
			BufferedWriter pisane = new BufferedWriter(new FileWriter("lines.txt"));
			PrintWriter pisec = new PrintWriter(pisane,true);
			
				while(line!=null){
					String upper = line.toUpperCase();
			        pisec.println(upper);
					line = chetec.readLine();
			
				}
				pisane.close();		
				chetec.close();
				pisec.close();
		}
			catch(FileNotFoundException e){
				System.out.println(e);
			}
			catch(Exception d){
				System.out.println(d);
			}

	}

}
