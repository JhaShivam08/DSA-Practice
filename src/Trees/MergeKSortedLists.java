
import java.util.PriorityQueue;

public class MergeKSortedLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq =
                new PriorityQueue<>((a, b) ->
                        Integer.compare(a.val, b.val));

        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {

            ListNode node = pq.poll();

            if (node.next != null) {
                pq.offer(node.next);
            }

            tail.next = node;
            tail = node;
        }

        return dummy.next;
    }

    static void display(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {

        ListNode a = new ListNode(1);
        a.next = new ListNode(4);
        a.next.next = new ListNode(7);

        ListNode b = new ListNode(2);
        b.next = new ListNode(5);
        b.next.next = new ListNode(8);

        ListNode c = new ListNode(3);
        c.next = new ListNode(6);
        c.next.next = new ListNode(9);

        ListNode[] lists = {a, b, c};

        ListNode result = mergeKLists(lists);

        display(result);
    }
}
