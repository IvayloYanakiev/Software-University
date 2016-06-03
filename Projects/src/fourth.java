import java.util.*;

public class fourth {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String[] b = a.split(" ");
        Queue<Integer> stack = new LinkedList<Integer>();

        int numbers = Integer.parseInt(b[0]);
        int s = Integer.parseInt(b[1]);
        int x = Integer.parseInt(b[2]);
        for (int i = 0; i < numbers; i++) {
            stack.add(scanner.nextInt());
        }
        ArrayList<Integer> list = new ArrayList<>();
        int min = 0;
        boolean checker = false;
        for (int i = 0; i < s; i++) {
            stack.remove();
        }



        while(!stack.isEmpty()){
            int dd = stack.remove();
            if(dd==x){
                checker = true;
                System.out.println(checker);
            }
            else if(dd!=x){

                list.add(dd);
            }


        }
        if(checker==false && !list.isEmpty()){
            Collections.sort(list);
            System.out.println(list.get(0));
        }
        if(list.isEmpty()){
            System.out.println("0");
        }


    }




}


