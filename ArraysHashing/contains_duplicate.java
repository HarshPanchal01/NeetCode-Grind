package ArraysHashing;
import java.util.HashSet;

public class contains_duplicate {
    public static boolean hasDuplicate(int[] nums) {
        HashSet<Integer> unique_nums = new HashSet<Integer>(); // create hashset as they can't contain duplicates

        for (int i = 0; i < nums.length; i++) { // loop through the array and add to hashset until it already exists
            if (unique_nums.contains(nums[i])) {
                return true;
            }
            unique_nums.add(nums[i]); // add to the set if not already there
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3};
        int[] nums2 = {1, 2, 3, 4};

        System.out.println(hasDuplicate(nums));
        System.out.println(hasDuplicate(nums2));

        // time and space complexity is O(n) as its looping an entire array
    }
}
