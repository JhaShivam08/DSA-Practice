
import java.util.PriorityQueue;
import java.util.Comparator;

public class KthSmallestElement {

    public static int findKthSmallest(int[] nums, int k) {

        // Create a Max Heap
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Comparator.reverseOrder());

        // Traverse every element of the array
        for (int num : nums) {

            // If heap size is less than k, insert the element
            if (maxHeap.size() < k) {
                maxHeap.offer(num);
            }

            // If current number is smaller than heap root
            else if (num < maxHeap.peek()) {

                // Remove the largest element
                maxHeap.poll();

                // Insert the current smaller number
                maxHeap.offer(num);
            }
        }

        // Root of Max Heap is the Kth smallest element
        return maxHeap.peek();
    }

    public static void main(String[] args) {

        int[] nums = {7, 10, 4, 3, 20, 15};

        int k = 3;

        int answer = findKthSmallest(nums, k);

        System.out.println("Kth Smallest Element = " + answer);
    }
}
