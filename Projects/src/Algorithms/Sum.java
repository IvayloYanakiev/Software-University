package Algorithms;

/**
 * Created by Happiness on 5.6.2016 г..
 */
public class Sum {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5} ;
        int sum = Sum(arr,0);

        System.out.println(sum);
    }

    static int Sum(int arr[],int index){
        if(index==arr.length){
            return 0;
        }
        return arr[index] + Sum(arr,index+1);
    }
}
