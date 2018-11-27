import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] A = {3, 6, 10, 18, 8, 7, 25, 40};
        quickSort(A, 0, A.length-1);
        show(A); // display the sorted result A
    }

    public static void quickSort(int[] A, int i, int j) {
        if(i < j) {
            int h = partition(A, i, j);
            quickSort(A, i, h-1);
            quickSort(A, h+1, j);
        }
    }

    public static void show(int[] A) {
        System.out.println(Arrays.toString(A));
    }

    // add all other functions you need
    public static int partition(int[] A, int i, int j) {
        int val = A[i];
        int h = i;
        for(int k = i+1; k < j; k++) {
            if(A[k] < val) {
                h++;
                swap(A, h, k);
            }
        }
        swap(A, i, h);

        return h;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}