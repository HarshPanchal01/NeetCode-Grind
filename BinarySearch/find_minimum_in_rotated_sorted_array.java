public class find_minimum_in_rotated_sorted_array {
    public static int findMin(int[] nums) {
        /*
        Brute Force O(n) approach

        int min = nums[0];
        for (int n : nums) {
            min = Math.min(min, n);
        }
        return min;
        */

        int left = 0, right = nums.length - 1, mid; // pointers for binary search

        while (left <= right) { // applying binary search approach, as long as left and right dont cross
            mid = left + (right - left) / 2; // calculate mid

            if (mid > 0 && nums[mid] < nums[mid - 1]) { // since we know its sorted and it can only be rotated, find the part that isnt sorted because if the number before mid is greater than this portion is not sorted and its where the rotation occured, meaning this is the minimum
                return nums[mid];
            }
            else if (nums[left] <= nums[mid] && nums[mid] > nums[right]) { // otherwise if the left side is sorted shift to try and find the unsorted portion
                left = mid + 1;
            }
            else { // apply same here and shift right pointer
                right = mid - 1;
            }
        }

        return nums[left];
    }
    public static void main(String[] args) {
        int[] nums = {3,4,5,6,1,2}, nums2 = {4,5,0,1,2,3};

        System.out.println(findMin(nums));
        System.out.println(findMin(nums2));

        // time complexity of this is O(log(n)) because of binary search and the space complexity is O(1)
    }
}
