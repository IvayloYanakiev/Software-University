package API;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Happiness on 14.6.2016 г..
 */
public class proba {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        a.stream().filter(b -> b>=3).forEach(c -> System.out.println(c));
    }
}
