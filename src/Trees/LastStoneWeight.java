import java.util.*;

public class LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {

        // Create a Max Heap
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Comparator.reverseOrder());

        // Insert all stones into the heap
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        // Continue while at least two stones exist
        while (maxHeap.size() > 1) {

            // Remove the heaviest stone
            int first = maxHeap.poll();

            // Remove the second heaviest stone
            int second = maxHeap.poll();

            // If weights are different, insert their difference
            if (first != second) {
                maxHeap.offer(first - second);
            }
        }

        // Return 0 if empty, otherwise return remaining stone
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    public static void main(String[] args) {

        int[] stones = {2, 7, 4, 1, 8, 1};

        int result = lastStoneWeight(stones);

        System.out.println("Last Stone Weight: " + result);
    }
}