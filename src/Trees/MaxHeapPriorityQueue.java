
import java.util.PriorityQueue;
import java.util.Comparator;

public class MaxHeapPriorityQueue {

    public static void main(String[] args) {

        // Create a Max Heap
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Comparator.reverseOrder());

        // Insert elements into the Max Heap
        maxHeap.offer(10);
        maxHeap.offer(5);
        maxHeap.offer(20);
        maxHeap.offer(2);

        // Display the largest element
        System.out.println("Largest element: " + maxHeap.peek());

        // Remove and print the largest element
        System.out.println("Removed: " + maxHeap.poll());

        // Display the next largest element
        System.out.println("Next largest: " + maxHeap.peek());

        // Check the size of the heap
        System.out.println("Size: " + maxHeap.size());

        // Check whether the heap contains 5
        System.out.println("Contains 5: " + maxHeap.contains(5));

        // Remove a particular value
        maxHeap.remove(5);

        // Check whether the heap is empty
        System.out.println("Is Empty: " + maxHeap.isEmpty());

        // Remove remaining elements in priority order
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }
    }
}
