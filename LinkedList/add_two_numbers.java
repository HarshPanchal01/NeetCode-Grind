public class add_two_numbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*
        Create:
            a dummy node (to build the answer)
            a pointer cur pointing to dummy
            an integer carry = 0

        Loop while l1 exists, l2 exists, or carry is non-zero:
            Read the current digit of each list (0 if that list already ended)
            Compute
            sum = v1 + v2 + carry
            Update:
            carry = sum // 10
            digit = sum % 10
            Append a new node containing digit
            Move the pointers l1, l2, and cur forward

        Return dummy.next (the head of the result list)        
        */
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;

            int val = v1 + v2 + carry;
            carry = val / 10;
            val = val % 10;
            cur.next = new ListNode(val);

            cur = cur.next;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        return dummy.next;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(6);

        print(addTwoNumbers(l1, l2));

        // time complexity is O(max(m,n)) and the space complexity is O(1)
    }
}
