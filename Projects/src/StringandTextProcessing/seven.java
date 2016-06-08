package StringandTextProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Happiness on 30.5.2016 г..
 */
public class seven {
    public static void main(String[] args) throws IOException,IndexOutOfBoundsException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String input2 = reader.readLine();
        int ostatuk=0;
        String a = "asd";

        if(input.length()>input2.length()){
        for (int i = input.length(); i >= 0; i--) {
            for (int j = 0; j < input.length()-input2.length(); j++) {
                input2 = 0+input2;
            }
            String newnumber = "";
            int first = input.charAt(i);
            int second = input2.charAt(i);
            int sum = first+second+ostatuk;

            if(sum>=10){
                sum=sum%10;
                ostatuk = (int)((sum)/10);

            }
            else{
                newnumber +=sum;
            }


        }}
        if(input2.length()>input.length()){
            for (int i = input2.length(); i >= 0; i--) {

            }}

    }
}
