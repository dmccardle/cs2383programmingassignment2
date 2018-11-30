import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] A = {3, 6, 10, 18, 8, 7, 25, 40};
        sort(A, 0, A.length - 1);
        show(A); // display the sorted result A
    }

    public static void sort(int[] A, int low, int high) {
        if (low < high) {
            int middle = (high + low) / 2;
            // left half
            sort(A, low, middle);
            // right half
            sort(A, middle+1, high);

            // merge the two halves
            merge(A, low, middle, high);
        }
    }

    public static void show(int[] A) {
        System.out.println(Arrays.toString(A));
    }
    // add all other functions you need

    /**
     * @param arr the array to be merged
     * @param l the low index
     * @param m the middle of the array
     * @param h the high index
     */
    public static void merge(int[] arr, int l, int m, int h) {
        // split into two half arrays

        // first one is l to m
        int[] left = new int[m - l + 1];
        // second is m to h
        int[] right = new int[h - m];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[l + i];
        }  
        for (int i = 0; i < right.length ; i++) {
            right[i] = arr[m + i + 1];
        }

        // compare the values in the arrays, inserting the smaller of the two in the array
        int leftIndex = 0, rightIndex = 0;
        // index of merged array
        int k = l;
        // exit once you reach the end of one of the arrays
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                arr[k] = left[leftIndex];
                // move one further in the left array since its value was merged
                leftIndex++;
            } else {
                arr[k] = right[rightIndex];
                // move one further in the right array since its value was merged
                rightIndex++;
            }
            // move one space in the array
            k++;
        }

        // if there is any left in the left array
        while (leftIndex < left.length) {
            arr[k] = left[leftIndex];
            leftIndex++;
            k++;
        }

        // if there is any left in the right array
        while (rightIndex < right.length) {
            arr[k] = right[rightIndex];
            rightIndex++;
            k++;
        }
        
    }
}