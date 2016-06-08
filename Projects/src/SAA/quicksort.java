package SAA;


public class quicksort {
    public static void main(String[] args) {
        int[] asd = {5, 4, 2, 3, 1};
        quickSort(asd, 0, 4);
        for (int i : asd) {
            System.out.println(i);
        }

        String asdd;
    }

    public static void quickSort(int arr[], int left, int right) {

        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];


        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        ;



        if (left < j)
            quickSort(arr, left, j);
        if (i < right)
            quickSort(arr, i, right);
    }
}
