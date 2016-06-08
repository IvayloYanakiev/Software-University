package SAA;


public class bubblesort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 1, 3};
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
