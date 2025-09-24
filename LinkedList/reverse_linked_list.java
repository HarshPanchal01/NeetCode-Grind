public class reverse_linked_list {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null; // set prev to be empty right now

        while (head != null) { // as long as our list isnt finished
            ListNode nextNode = head.next; // get the next node in list
            head.next = prev; // make the next node equal to prev node
            prev = head; // make prev the current node
            head = nextNode; // make our list go to next node
        }

        return prev;
    }

    public static void print(ListNode head) {
        ListNode currentNode = head;

        while (currentNode != null) {
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);

        print(reverseList(head));

        // Time complexity is O(n) and Space complexity is O(1)
    }    
}
