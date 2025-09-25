public class merge_two_sorted_linked_list {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy; // this will be the pointer that moves

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) { // compare the values and add since it needs to be sorted
                tail.next = new ListNode(list1.val);
                list1 = list1.next; // go to next node
            } 
            else { // same as above just if list 2 val was smaller
                tail.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            tail = tail.next; // make our pointer go next
        }

        while (list1 != null) { // if list 2 finished but list 1 didnt
            tail.next = new ListNode(list1.val);
            list1 = list1.next;
            tail = tail.next;
        }
        while (list2 != null) { // vice-versa from above while loop
            tail.next = new ListNode(list2.val);
            list2 = list2.next;
            tail = tail.next;
        }

        return dummy.next;  // return head, skip dummy
    }

    public static void print(ListNode head) {
        ListNode currentNode = head;

        while (currentNode != null) {
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
    }
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(5);

        print(mergeTwoLists(list1, list2));

        // Time complexity is O(n + m) and space complexity is O(1)
    }
}
