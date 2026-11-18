import java.util.Arrays; // Used to print the array easily

public class HeapSort {

    // This method maintains the Max Heap property
    static void heapify(int[] arr, int n, int i) {

        while (true) {

            int largest = i;          // Assume current node is largest
            int left = 2 * i + 1;     // Calculate left child index
            int right = 2 * i + 2;    // Calculate right child index

            // Check whether left child is greater
            if (left < n && arr[left] > arr[largest]) {
                largest = left;
            }

            // Check whether right child is greater
            if (right < n && arr[right] > arr[largest]) {
                largest = right;
            }

            // If current node is already largest, stop
            if (largest == i) {
                break;
            }

            // Swap current node with the largest child
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Continue heapifying from the swapped position
            i = largest;
        }
    }

    // This method builds a Max Heap and sorts the array
    static void heapSort(int[] arr) {

        int n = arr.length; // Store the array size

        // Build the Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Move the largest element to the end repeatedly
        for (int end = n - 1; end > 0; end--) {

            // Swap root (largest) with the last element
            int temp = arr[0];
            arr[0] = arr[end];
            arr[end] = temp;

            // Restore Max Heap in the remaining elements
            heapify(arr, end, 0);
        }
    }

    // Main method: program execution starts here
    public static void main(String[] args) {

        int[] arr = {9, 4, 7, 1, 3, 6, 2};

        System.out.println("Original Array: "
                + Arrays.toString(arr));

        heapSort(arr); // Call Heap Sort

        System.out.println("Sorted Array: "
                + Arrays.toString(arr));
    }
}