package Algorithms;

/**
 * Created by Happiness on 5.6.2016 г..
 */
public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        reversed(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
    static void reversed(int[] arr,int index,int index1){
        if(index >= index1){
         return;
        }
        int temp = arr[index];
        arr[index] = arr[index1];
        arr[index1]= temp;

        reversed(arr,index+1,index1-1);



    }
}
