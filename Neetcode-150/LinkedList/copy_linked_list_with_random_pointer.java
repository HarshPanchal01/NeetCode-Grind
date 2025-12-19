import java.util.HashMap;
import java.util.Map;

public class copy_linked_list_with_random_pointer {
    public static class Node {
        int val;
        Node next;
        Node random;
        Node(int val) { this.val = val; this.next = null; this.random = null; }
    }
    
    public static Node copyRandomList(Node head) {
        Map<Node, Node> oldToCopy = new HashMap<>();
        oldToCopy.put(null, null);

        // pass 1: create a copy of every node and store the mapping
        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            oldToCopy.put(cur, copy);
            cur = cur.next;
        }

        // pass 2: use this map to connect next and random pointers for each copied node
        cur = head;
        while (cur != null) {
            Node copy = oldToCopy.get(cur);
            copy.next = oldToCopy.get(cur.next);
            copy.random = oldToCopy.get(cur.random);
            cur = cur.next;
        }

        return oldToCopy.get(head);
    }

    public static void print(Node head) {
        Node dummy = head;

        while (dummy != null) {
            System.out.println(dummy.val);
            dummy = dummy.next;
        }

        dummy = head;

        while (dummy != null) {
            System.out.println(dummy.val);
            dummy = dummy.random;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(7);
        head.next.random = new Node(5);
        head.next.next = new Node(4);
        head.next.next.random = head;
        head.next.next.next = head.next.random;
        head.next.random.random = head.next;

        //print(head);
        print(copyRandomList(head));

        // time complexity is O(n) and space complexity is also O(n) due to map
    }
}
