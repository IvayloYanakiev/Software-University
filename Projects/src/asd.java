import java.util.*;

/**
 * Created by Happiness on 5/17/2016.
 */
public class asd {
    public static void main(String[] args) {
        HashMap<String,HashMap<String,Integer>> asd = new HashMap<>();
        HashMap<String,Integer> asd1 = new HashMap<>();
        asd.put("Ivo",asd1);
        asd.get("Ivo").put("Qnakiev",21);
        System.out.println(asd.get("Ivo").get("Qnakiev"));
    }
}
