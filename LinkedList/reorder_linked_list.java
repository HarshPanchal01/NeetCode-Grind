import java.util.List;
import java.util.ArrayList;

public class reorder_linked_list {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void reorderList(ListNode head) {
        if (head == null) return;

        // Step 1: put all nodes into an ArrayList
        List<ListNode> nodes = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            nodes.add(current);
            current = current.next;
        }

        // Step 2: reorder using two pointers
        int i = 0, j = nodes.size() - 1;
        while (i < j) {
            nodes.get(i).next = nodes.get(j);   // link from start → end
            i++;
            if (i == j) break;                  // middle reached for odd length
            nodes.get(j).next = nodes.get(i);   // link from end → next start
            j--;
        }

        // Step 3: terminate list
        nodes.get(i).next = null;
    }

    public static void print(ListNode head) {
        ListNode currentNode = head;

        while (currentNode != null) {
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
    }
    public static void main(String[] args) {
       ListNode head = new ListNode(2);
       head.next = new ListNode(4);
       head.next.next = new ListNode(6);
       head.next.next.next = new ListNode(8);
       
       print(head);

       // Time complexity is O(n) and Space complexity is O(n)
    }
}