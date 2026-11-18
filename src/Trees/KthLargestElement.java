
import java.util.PriorityQueue;

public class KthLargestElement {

    public static int findKthLargest(int[] nums, int k) {

        // Create a Min Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Traverse every element of the array
        for (int num : nums) {

            // If heap size is less than k, insert the element
            if (minHeap.size() < k) {
                minHeap.offer(num);
            }

            // If current number is greater than heap root
            else if (num > minHeap.peek()) {

                // Remove the smallest element
                minHeap.poll();

                // Insert the current number
                minHeap.offer(num);
            }
        }

        // Root of Min Heap is the Kth largest element
        return minHeap.peek();
    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 1, 5, 6, 4};

        int k = 2;

        int answer = findKthLargest(nums, k);

        System.out.println("Kth Largest Element = " + answer);
    }
}
