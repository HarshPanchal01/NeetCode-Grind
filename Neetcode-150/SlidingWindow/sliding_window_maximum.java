import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Deque;

public class sliding_window_maximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        /*
        Brute Force O(n * k) solution

        List<Integer> max_list = new ArrayList<>();
        int max_window = Integer.MIN_VALUE, counter = 0;

        for (int i = 0; i <= nums.length - k; i++) { // you only need to loop for all windows that can be made
            while (counter < k) { // to check for all elements that can be in the window in this iteration
                max_window = Math.max(max_window, nums[i + counter]); // update max
                counter++;
            }
            max_list.add(max_window); // add the max to our max value list
            counter = 0;
            max_window = Integer.MIN_VALUE;
        }

        // turn our list into array and then return
        int[] result = new int[max_list.size()];
        for (int i = 0; i < max_list.size(); i++) {
            result[i] = max_list.get(i);
        }

        return result;
        */

        int n = nums.length;

        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>(); // store indices, values in decreasing order
        int ri = 0;

        for (int i = 0; i < n; i++) {
            // 1) remove indices out of the current window (i - k + 1 is first valid index)
            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }

            // 2) maintain decreasing property: remove smaller values from the back
            // use '<' so that equal values keep the older index (stability)
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // 3) add current index
            dq.offerLast(i);

            // 4) record the max for windows that are fully formed
            if (i >= k - 1) {
                result[ri++] = nums[dq.peekFirst()];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,1,0,4,2,6};
        int k = 3;

        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));

        // Time complexity: O(n) Space complexity: O(n)
    }
}
