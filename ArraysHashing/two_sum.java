import java.util.Arrays;
import java.util.HashMap;

public class two_sum {
    public static int[] twoSum(int[] nums, int target) {
        /* Brute force O(n^2)
        int[] output = new int[2];
        
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    output[0] = i;
                    output[1] = j;
                }
            }
        }

        return output;*/

        // optimal O(n) time complexity with hashmap
        HashMap<Integer, Integer> nums_map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums_map.containsKey(target - nums[i])) { // check if the difference between the target and current value exists in hashmap
                return new int[] {nums_map.get(target - nums[i]), i}; // return the indexes if it does because they will sum to target
            }
            else { // otherwise put the value and its index
                nums_map.put(nums[i], i);
            }
        }

        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 6}, nums2 = {4, 5, 6};
        int target = 7, target2 = 10;
        
        System.out.println(Arrays.toString(twoSum(nums, target)));
        System.out.println(Arrays.toString(twoSum(nums2, target2)));

        // time and space complexity will be O(n) with hashmaps
    }
}
