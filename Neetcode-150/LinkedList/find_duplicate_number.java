import java.util.Arrays;

public class find_duplicate_number {
    public static int findDuplicate(int[] nums) {
        /*
        Brute Force O(n^2) approach that keeps O(1) extra space and without modifying nums
        int dup = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            dup = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (dup == nums[j]) {
                    return dup;
                }
            }
        }

        return dup;
        */
        
        /*
        Negative Marking
        Intuition

        Since every value is between 1 and n, each number corresponds to an index in the array (num - 1).
        We can use the array itself as a marking tool:

           - When we see a number, we go to its corresponding index and flip the sign of the value there.
           - If we ever visit an index that is already negative, it means we've visited this number before → it's the duplicate.

        This method avoids extra memory and uses the input array as a tracking structure.
        */

        // loop through every number in the array
        for (int i : nums) {
            // compute its index as if it were sorted
            int index = Math.abs(i) - 1;
            // if the number at that index is already negative return the number because thats a duplicate
            if (nums[index] < 0) {
                return Math.abs(i);
            }
            // otherwise make the number at that index negative to mark it if we see it again
            nums[index] *= -1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,2};

        System.out.println(findDuplicate(nums));

        // goal is to solve this problem using O(1) extra space and without modifying the array itself
        // time complexity is O(n) and space complexity is O(1)
    }
}
