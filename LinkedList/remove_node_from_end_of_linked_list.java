import java.util.ArrayList;
import java.util.List;

public class remove_node_from_end_of_linked_list {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();

        ListNode currentNode = head;

        while (currentNode != null) { // add the list to arraylist
            nodes.add(currentNode);
            currentNode = currentNode.next;
        }

        ListNode new_list = new ListNode(); // create new list to store all but the removed index
        ListNode dummy = new_list;
        int idx_to_rmv = nodes.size() - n; // find the index where we need to remove from the list

        if (n == 1) { // if we need to only remove the last node
            for (int i = 0; i < nodes.size() - 1; i++) { // we will not loop until the last
                dummy.next = nodes.get(i);
                dummy = dummy.next;
            }
            dummy.next = null; // cut off references to old tail
        }

        else {
            for (int i = 0; i < nodes.size(); i++) {
                if (i == idx_to_rmv) { // if this is the index to remove
                    i++; // go forward
                    dummy.next = nodes.get(i); // add the next node
                }
                else {
                    dummy.next = nodes.get(i);
                }
                dummy = dummy.next;
            }
            dummy.next = null; // cut off references to old tail
        }

        return new_list.next;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        
        int n = 2;

        print(removeNthFromEnd(head, n));

        // Time complexity is O(n) and Space complexity is O(n)
    }
}
