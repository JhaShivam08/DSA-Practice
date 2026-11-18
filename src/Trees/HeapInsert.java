
import java.util.ArrayList;

public class HeapInsert {

    ArrayList<Integer> heap = new ArrayList<>();

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

    public void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void display() {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        HeapInsert obj = new HeapInsert();

        obj.insert(10);
        obj.insert(5);
        obj.insert(20);
        obj.insert(2);
        obj.insert(8);

        obj.display();
    }
}
