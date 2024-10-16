import java.util.Arrays;

public class product_array_except_self {
    public static int[] productExceptSelf(int[] nums) {
        int[] product_arr = new int[nums.length];

        /*
        Brute force O(n^2)
        int curr_product = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    curr_product *= nums[j];
                }
            }
            product_arr[i] = curr_product;
            curr_product = 1;
        }

        return product_arr;
        */

        int product = 1, zero_count = 0; // counters

        for (int n : nums) { // loop through and calculate the product of all numbers
            if (n != 0) {
                product *= n;
            }
            else {
                zero_count++;
            }
        }

        if (zero_count > 1) { // if there is more than 1 zero in the array return same array with all 0s because it means product will always be zero no matter what
            return new int[nums.length];
        }

        for (int i = 0; i < nums.length; i++) { // loop through to add to the return array
            if (zero_count > 0) { // if there is 1 zero in the array
                product_arr[i] = (nums[i] == 0) ? product : 0; // add the product if we are at 0 now otherwise add 0
            } 
            else { // if there are no zeroes in the array
                product_arr[i] = product / nums[i]; // add the product divided by current element to get the product without self
            }
        }

        return product_arr;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6}, nums2 = {-1, 0, 1, 2, 3};
        
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        System.out.println(Arrays.toString(productExceptSelf(nums2)));

        // time complexity is O(n) and space complexity is O(1)
    }
}
