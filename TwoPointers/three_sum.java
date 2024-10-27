import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class three_sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        /*
        Brute Force approach O(n^3)

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list_sum = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(list_sum);

                        if (!list.contains(list_sum)) {
                            list.add(list_sum);
                        }
                    } 
                }
            }
        }
        return list;
        */
        
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums); // sort the array so we can use two-pointer approach

        for (int i = 0; i < nums.length - 2; i++) { // loop through array expect for last two elements as we need those for the pointer to not be out of bounds
            int left = i + 1, right = nums.length - 1, sum = 0; // pointers and variable to hold the sum

            while (left < right) { // apply the two-pointer approach as long as the left pointer is less than the right
                sum = nums[left] + nums[right] + nums[i]; // calculate the sum of i with left and right

                if (sum == 0) { // if it is 0 then we can add to the list if not already there
                    List<Integer> list_sum = Arrays.asList(nums[i], nums[left], nums[right]);
                    Collections.sort(list_sum); // sort the list before adding so we can check if its in there

                    if (!list.contains(list_sum)) { // add to list if its not there
                        list.add(list_sum);
                    }

                    right--; // decrement right, it doesnt matter if you decrement this or increment left you just need to do one so the loop continues
                }
                else if (sum > 0) { // if the sum was greater than 0 we can decrement right because the array is sorted and right would be greatest element
                    right--;
                }
                else { // otherwise increment left because it would mean that the sum was less than 0
                    left++;
                }
            }
        }

        return list;
    }
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4}, nums2 = {0,1,1}, nums3 = {0,0,0};

        System.out.println(threeSum(nums));
        System.out.println(threeSum(nums2));
        System.out.println(threeSum(nums3));
        
        // time complexity is O(n^2) with the while loop nested in the for loop, and the space complexity is O(n) for the list of lists
    }
}