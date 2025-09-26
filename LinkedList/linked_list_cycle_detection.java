import java.util.HashSet;

public class linked_list_cycle_detection {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>(); // since its a cycle problem it means that there will be duplicate if true so lets use a set

        while (head != null) { // loop through the list
            if (set.contains(head)) { // if we already have this node in the set theres a cycle
                return true;
            }
            set.add(head); // add the node to the set
            head = head.next; // go to next node
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;

        System.out.println(hasCycle(head));

        // Time complexity is O(n) and space complexity is O(n) cause of hashset
    }
}
