import java.util.ArrayList;
import java.util.HashMap;

public class Grades extends CSVDatabase{
int studentid;
public HashMap<String,ArrayList<Integer>> course1 = new HashMap<>();
public HashMap<String,ArrayList<Integer>> course2 = new HashMap<>();

	Grades(int Studentid,HashMap<String,ArrayList<Integer>> predmet,HashMap<String,ArrayList<Integer>> predmet2){
		this.studentid=Studentid;
		this.course1=predmet;
		this.course2=predmet2;
		
		
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public HashMap<String, ArrayList<Integer>> getCourse1() {
		return course1;
	}

	public void setCourse1(HashMap<String, ArrayList<Integer>> course1) {
		this.course1 = course1;
	}

	public HashMap<String, ArrayList<Integer>> getCourse2() {
		return course2;
	}

	public void setCourse2(HashMap<String, ArrayList<Integer>> course2) {
		this.course2 = course2;
	}
	
	
}
