import java.util.Arrays;

public class MergeSort {
    
    public static void main(String[] args) {
        int[] A = {3, 6, 10, 18, 8, 7, 25, 40};
        mergeSort(A, 0, A.length-1);
        show(A); // display the sorted result A
    }

    public static void mergeSort(int[] A, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            // mergeSort the two halves
            mergeSort(A, left, middle);
            mergeSort(A, middle+1, right);

            merge(A, left, middle, right);
        }
    }

    public static void show(int[] A) {
        System.out.println(Arrays.toString(A));
    }
    // add all other functions you need

    public static void merge(int[] A, int low, int middle, int high) {
        int size = A.length;
        int[] helperArray = new int[size];
        for (int i = low; i < high; i++) {
            helperArray[i] = A[i];
        }
        
        int i = low, j = middle + 1, k = low;
        while (i <= middle && j <= high) {
            if (helperArray[i] <= helperArray[j]) {
                A[k] = helperArray[i]; i++;
            } else {
                A[k] = helperArray[j]; j++;
            }
            k++;
        }

        while (i <= middle) {
            A[k] = helperArray[i];
            k++; i++;
        }
    }
}