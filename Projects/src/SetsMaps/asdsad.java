package SetsMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class asdsad {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Ivo", 1);
        map.put("todor", 2);
        map.put("jelqzko", 3);
        map.put("Gorgo", 4);
        map.entrySet().stream().sorted((c, c1) -> (c1.getValue().compareTo(c.getValue())))
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));


        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            ArrayList<Integer> asd = new ArrayList<>();
            for (int j = 0; j < 5; j++) {

                asd.add(j);
            }
            matrix.add(asd);
        }
        List<Integer> arr=new ArrayList<Integer>(){{
            add(4);
            add(3);
        }};

        matrix.get(2).removeAll(new ArrayList<Integer>(){{add(3);add(4);add(5);add(1);add(2);add(0);}});

        for (int i = 0; i <matrix.size() ; i++) {
            if(matrix.get(i).size()==0){
                matrix.remove(i);
            }
        }
        for (ArrayList<Integer> integers : matrix) {

            for (Integer integer : integers) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
