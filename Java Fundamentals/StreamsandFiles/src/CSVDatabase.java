import java.util.ArrayList;
import java.util.HashMap;

public class CSVDatabase {

	public static void main(String[] args) {
		HashMap<String,ArrayList<Integer>> grades = new HashMap<>();
		grades.put("Math",new ArrayList<Integer>());
		grades.get("Math").add(1);
		
		HashMap<String,ArrayList<Integer>> grades1 = new HashMap<>();
		grades1.put("Math2",new ArrayList<Integer>());
		grades1.get("Math2").add(21);
		

		Student Ivo = new Student(5,"Ivailo","Qnakiev", 21,"Burgas");
		Grades ocenkaivo = new Grades(5,grades,grades1);
		
		
		System.out.println(ocenkaivo.course1);
		System.out.println(ocenkaivo.course2);
	}

}
