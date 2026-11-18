import java.util.PriorityQueue;

public class TopKLargestElements {

    // Approach A: Insert every number, then remove excess elements
    public static void approachA(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        System.out.println("Approach A - Top " + k + " largest:");

        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }

        System.out.println();
    }

    // Approach B: Compare each number with the root first
    public static void approachB(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {

            if (pq.size() < k) {
                pq.offer(num);
            }
            else if (num > pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }

        System.out.println("Approach B - Top " + k + " largest:");

        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 3;

        approachA(nums, k);
        approachB(nums, k);
    }
}