import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class first {
    public static void main(String[] args) {

        Scanner scanner=  new Scanner(System.in);
        String number = scanner.nextLine();
        ArrayList<Integer> list = new ArrayList<>();
        int count =0;
        if(Integer.parseInt(number)>=1 && Integer.parseInt(number)<=105){
        for (int i = 0; i < Integer.parseInt(number); i++) {
            String input = scanner.nextLine();
            String[] a = input.split(" ");
            int b = Integer.parseInt(a[0]);

            if(b==1){
                int c = Integer.parseInt(a[1]);
                if(c>=1 && c<=109){
                    list.add(c);
                }
            }
            else if(b==2){
                if(!list.isEmpty()){
                    list.remove(list.size()-1);
                }
                else continue;
            }
            else if(b==3){
                Collections.sort(list);
                System.out.println(list.get(list.size()-1));
            }

        }
    }}
}
