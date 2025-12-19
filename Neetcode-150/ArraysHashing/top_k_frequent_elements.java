import java.util.Arrays;
import java.util.HashMap;

public class top_k_frequent_elements {
    public static int[] topKFrequent(int[] nums, int k) {
        int[] most_frequent = new int[k]; // set the array to hold the kth most frequent elements
        int count = 0, element = 0; // counters for times a number appears and the element of it

        HashMap<Integer, Integer> nums_map = new HashMap<>(); // idea is to store the element along with the number of its frequency

        for (int i = 0; i < nums.length; i++) {
            if (!nums_map.containsKey(nums[i])) { // put it into the hashmap and set value to 1 since its first occurence
                nums_map.put(nums[i], 1);
            }
            else {
                nums_map.put(nums[i], nums_map.get(nums[i]) + 1); // increase the value of the element as its appeared again
            }
        }

        for (int i = 0; i < k; i++) { // loop through to put most common elements up to kth in the array to return
            for (int key : nums_map.keySet()) { // search through the hashmap to find highest value or occurence in this case
                if (count < nums_map.get(key)) {
                    count = nums_map.get(key); // get the number of occurence
                    element = key; // get the element
                }
            }
            most_frequent[i] = element; // store the element
            nums_map.remove(element); // remove it from the hashmap so it does not consider it again
            count = 0; // reset counter
        }

        return most_frequent;
    }   
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 3}, nums2 = {7, 7};
        int k = 2, k2 = 1;

        System.out.println(Arrays.toString(topKFrequent(nums, k)));
        System.out.println(Arrays.toString(topKFrequent(nums2, k2)));

        // time complexity is O(n * k) where n is the length of the array nums and k is the integer of which to find kth frequency elements for
    }
}
