import java.awt.List;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SaveanArrayListofdoubles {

	public static void main(String[] args) {
		try {
			BufferedOutputStream pisane = new BufferedOutputStream(new FileOutputStream("doubles.list"));
			ObjectOutputStream pisec = new ObjectOutputStream(pisane);
			ArrayList<Double> array = new ArrayList<Double>();
			array.add(3.5);
			array.add(3.6);
			array.add(3.7);
			array.add(3.8);
			array.add(3.9);
			System.out.println(array);
			pisec.writeObject(array);
		
			pisec.close();
			pisane.close();
		   
			BufferedInputStream chetene = new BufferedInputStream(new FileInputStream("doubles.list"));
			ObjectInputStream chetec = new ObjectInputStream(chetene); 
			ArrayList<Double> array1 = (ArrayList<Double>) chetec.readObject();
			System.out.println(array1);
			chetec.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
			
		
	}

}
