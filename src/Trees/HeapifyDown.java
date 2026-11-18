
import java.util.ArrayList;

public class HeapifyDown {

    ArrayList<Integer> heap = new ArrayList<>();

    private void heapifyDown(int index) {
        int size = heap.size();

        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }

            if (right < size && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }

            if (smallest == index) {
                break;
            }

            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public static void main(String[] args) {
        HeapifyDown obj = new HeapifyDown();

        obj.heap.add(10);
        obj.heap.add(5);
        obj.heap.add(3);
        obj.heap.add(8);
        obj.heap.add(7);

        System.out.println("Before Heapify Down: " + obj.heap);

        obj.heapifyDown(0);

        System.out.println("After Heapify Down: " + obj.heap);
    }
}
