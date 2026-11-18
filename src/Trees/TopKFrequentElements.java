import java.util.*;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create Min Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(freq.get(a), freq.get(b))
        );

        // Step 3: Keep only K frequent elements
        for (int num : freq.keySet()) {
            minHeap.offer(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 4: Store result
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] result = topKFrequent(nums, k);

        System.out.println("Top K Frequent Elements: "
                + Arrays.toString(result));
    }
}