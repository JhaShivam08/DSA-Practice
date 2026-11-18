import java.util.*;

public class KClosestPointsToOrigin {

    // Calculate squared distance from origin
    private static long distance(int[] point) {
        long x = point[0];
        long y = point[1];

        return x * x + y * y;
    }

    public static int[][] kClosest(int[][] points, int k) {

        // Max Heap: farthest point stays at the root
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Long.compare(distance(b), distance(a))
        );

        // Keep only K closest points
        for (int[] point : points) {
            maxHeap.offer(point);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Store result
        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] points = {
                {1, 3},
                {-2, 2},
                {5, 8},
                {0, 1}
        };

        int k = 2;

        int[][] result = kClosest(points, k);

        System.out.println("K Closest Points: "
                + Arrays.deepToString(result));
    }
}