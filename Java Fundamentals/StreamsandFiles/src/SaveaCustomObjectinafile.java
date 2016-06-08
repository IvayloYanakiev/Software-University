import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SaveaCustomObjectinafile implements Serializable{

	public static void main(String[] args) {
		
		
		try(BufferedOutputStream pisec = new BufferedOutputStream(new FileOutputStream("course.save"));
				ObjectOutputStream pisecobject = new ObjectOutputStream(pisec);)
		{
			Course student1 = new Course("ivo", 123);
			Course student3 = new Course("teodor", 15);
			Course student2 = new Course();
		  
			pisecobject.writeObject(student1);
			pisecobject.writeObject(student3);
			pisecobject.writeObject(student2);
		   
			System.out.println(student1.name + " " + student1.number);
			System.out.println(student2.name + " " + student2.number);
			System.out.println(student3.name + " " + student3.number);

		}
		catch(Exception e){
			System.out.println(e);
		}
		
		try(BufferedInputStream chetec = new BufferedInputStream(new FileInputStream("course.save"));
				 ObjectInputStream chetecobject = new ObjectInputStream(chetec);) {
			
			while(true)
				try{
					Course course = (Course)chetecobject.readObject();
					System.out.println(course.name + " " + course.number);}
				catch (Exception ea) {
				break;
					
				}
			
		} 
		catch (Exception ea) {
			System.out.println(ea);
			
		}

	}
}
