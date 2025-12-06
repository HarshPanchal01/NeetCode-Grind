import java.util.ArrayList;
import java.util.Collections;

public class reverse_nodes_in_k_group {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        /*
        WTF is this below

        ArrayList<Integer> arr = new ArrayList<>();

        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            arr1.add(arr.get(i));
        }
        System.out.println(arr);

        int idx = 0;
        for (int i = k; i < arr.size() && i < k * 2; i++) {
            arr2.add(arr.get(i));
            idx = i;
        }

        Collections.reverse(arr1);
        if (!(arr2.size() < k)) {
            Collections.reverse(arr2);
        }

        System.out.println("arr1: " + arr1);
        System.out.println("arr2: " + arr2);

        ListNode merged = new ListNode(0);
        ListNode current = merged;

        for (int num : arr1) {
            current.next = new ListNode(num);
            current = current.next;
        }

        for (int num : arr2) {
            current.next = new ListNode(num);
            current = current.next;
        }

        if (!arr2.isEmpty()) {
            idx++;
            while (idx < arr.size()) {
                current.next = new ListNode(arr.get(idx));
                current = current.next;
                idx++;
            }
        }

        return merged.next;
        */

        ListNode cur = head;
        int group = 0;
        while (cur != null && group < k) {
            cur = cur.next;
            group++;
        }

        if (group == k) {
            cur = reverseKGroup(cur, k);
            while (group-- > 0) {
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            head = cur;
        }
        return head;
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
        head.next.next.next.next = new ListNode(5);
        //head.next.next.next.next.next = new ListNode(6);
        
        int k = 2;

        print(reverseKGroup(head, k));

        // time complexity is O(n) and space complexity is O(n/k)
    }
}
