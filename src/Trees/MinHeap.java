
import java.util.*;

public class MinHeap {

    private final ArrayList<Integer> heap = new ArrayList<>();

    // Swap two elements
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Insert an element
    public void insert(int value) {
        heap.add(value);

        int index = heap.size() - 1;

        while (index > 0) {
            int parent = (index - 1) / 2;

            if (heap.get(parent) <= heap.get(index)) {
                break;
            }

            swap(parent, index);
            index = parent;
        }
    }

    // Return the smallest element
    public int peek() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        return heap.get(0);
    }

    // Remove the smallest element
    public int remove() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        int min = heap.get(0);
        int last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return min;
    }

    // Restore Min Heap property
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

    // Display heap
    public void display() {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        MinHeap obj = new MinHeap();

        obj.insert(10);
        obj.insert(5);
        obj.insert(20);
        obj.insert(2);
        obj.insert(8);

        System.out.print("Min Heap: ");
        obj.display();

        System.out.println("Peek: " + obj.peek());
        System.out.println("Removed: " + obj.remove());

        System.out.print("After Removal: ");
        obj.display();
    }
}
