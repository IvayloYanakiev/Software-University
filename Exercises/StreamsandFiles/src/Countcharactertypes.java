import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Countcharactertypes {

	public static void main(String[] args) {
		try{
			
			BufferedReader chetec = new BufferedReader(new FileReader("words.txt"));
			String line = chetec.readLine();
			BufferedWriter pisane = new BufferedWriter(new FileWriter("count-chars.txt"));
			PrintWriter pisec = new PrintWriter(pisane,true);
			int countvowels =0;
			int countconsonants =0;
			int countPunctuation = 0;
			while(line!=null){
				
			for (int i = 0; i < line.length(); i++) {
				
				char a = line.charAt(i);
				if(a=='a'|| a=='e' ||a=='i'|| a=='o' || a=='u' || a=='A'|| a=='E' ||a=='I'|| a=='O' || a=='U'){
					countvowels++;
				}
				
				if(a=='!'|| a=='?' ||a=='.'|| a==','){
					countPunctuation++;
				}
				
				if(a=='b'|| a=='c' ||a=='d'|| a=='f' || a=='g'|| a=='h'|| a=='j'|| a=='k'|| a=='l'|| a=='m' || a=='n'
						|| a=='p' || a=='q' || a=='r'|| a=='s'|| a=='t'|| a=='v'|| a=='w'|| a=='x' || a=='y'|| a=='z'
						|| a=='B'|| a=='C' ||a=='D'|| a=='F' || a=='G'|| a=='H'|| a=='J'|| a=='K'|| a=='L'|| a=='M' || a=='N'
						|| a=='p' || a=='Q' || a=='R'|| a=='S'|| a=='T'|| a=='V'|| a=='W'|| a=='X' || a=='Y'|| a=='Z'){
					countconsonants++;
				}
				
			}
		
			
			line = chetec.readLine();
			
			
			}
			pisec.printf("Vowels:%d",countvowels);
			pisec.println();
			pisec.printf("Consonants:%d \n",countconsonants);
			pisec.println();
			pisec.printf("Punctuation:%d \n",countPunctuation);
			System.out.println(countvowels);
			System.out.println(countconsonants);
			System.out.println(countPunctuation);
			
			chetec.close();
			pisec.close();
			pisane.close();
		}
			catch(FileNotFoundException e){
				System.out.println(e);
			}
			catch(Exception d){
				System.out.println(d);
			}

	}

}
