import java.util.*;

public class MedianFinder {

    private PriorityQueue<Integer> left =
            new PriorityQueue<>(Comparator.reverseOrder());

    private PriorityQueue<Integer> right =
            new PriorityQueue<>();

    public void addNum(int num) {

        left.offer(num);
        right.offer(left.poll());

        if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {

        if (left.size() > right.size()) {
            return left.peek();
        }

        return (double) (left.peek() + right.peek()) / 2.0;
    }

    public static void main(String[] args) {

        MedianFinder mf = new MedianFinder();

        mf.addNum(1);
        mf.addNum(3);

        System.out.println("Median: " + mf.findMedian());

        mf.addNum(5);

        System.out.println("Median: " + mf.findMedian());
    }
}