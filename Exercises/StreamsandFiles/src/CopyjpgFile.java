import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CopyjpgFile {

	public static void main(String[] args) {
		try (BufferedInputStream inputStream = new BufferedInputStream(
                new FileInputStream("resources/MagicianLumpy.jpg"));
             BufferedOutputStream outputStream = new BufferedOutputStream(
                     new FileOutputStream("resources/MagicianLumpyCopy.jpg"))
        ) {
            int bytes = inputStream.read();
            while (bytes != -1) {
                outputStream.write(bytes);
 
                bytes = inputStream.read();
            } 
           }
			catch(FileNotFoundException e){
				System.out.println(e);
			}
			catch(Exception d){
				System.out.println(d);
			}
	}

}
