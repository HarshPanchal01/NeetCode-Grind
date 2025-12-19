import java.util.ArrayList;
import java.util.Collections;

public class merge_k_sorted_linked_lists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        /*
            Yeah idk, linkedlist is garbage so I just ignored the data structure, put them into an arraylist
            sorted that list and then put them into a linkedlist again to return

            Time complexity is O(nlogn) due to sorting and space complexity is O(n)
        */
       
        ListNode merged = new ListNode(0);
        ArrayList<Integer> arr = new ArrayList<>();

        for (ListNode list : lists) {
            while (list != null) {
                arr.add(list.val);
                list = list.next;
            }
        }

        Collections.sort(arr);

        ListNode current = merged;

        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }

        return merged.next;
    }

    public static void print(ListNode[] lists) {
        for (ListNode list : lists) {
            while (list != null) {
                System.out.println(list.val);
                list = list.next;
            }
        }
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];

        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(2);
        lists[0].next.next = new ListNode(4);
        
        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(5);

        lists[2] = new ListNode(3);
        lists[2].next = new ListNode(6);

        //print(lists);

        ListNode[] results = new ListNode[1];
        results[0] = mergeKLists(lists);
        print(results);
    }
}

