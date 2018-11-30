import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] A = {3, 6, 10, 18, 8, 7, 25, 40};
        // create a max heap
        for (int i = A.length / 2 - 1; i >= 0; i--) 
            siftDown(A, A.length-1, i);

        sort(A, 0, A.length - 1);
        show(A); // display the sorted result A
    }

    public static void sort(int[] A, int l, int r) {
        if (l < r) {
            // swap root node with last node
            swap(A, l, r);

            // heapify new section
            siftDown(A, r-1, l);

            // repeat
            sort(A, l, r-1);
        }
    }

    public static void show(int[] A) {
        System.out.println(Arrays.toString(A));
    }
    // add all other functions you need
    
    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private static void siftDown(int[] A, int n, int i) {
        int largest = i; 
        int left = 2*i + 1;
        int right = 2*i + 2;

        // checks left child
        if (left <= n && A[left] > A[largest]) {
            largest = left;
        }
        // checks right child
        if (right <= n && A[right] > A[largest]) {
            largest = right;
        }

        // if a new largest was found
        if (largest != i) {
            swap(A, i, largest);
            siftDown(A, n, largest);
        }
    }
}