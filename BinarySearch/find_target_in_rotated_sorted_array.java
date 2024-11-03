public class find_target_in_rotated_sorted_array {
    public static int search(int[] nums, int target) {
        /*
        Brute Force O(n) approach

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
        */
        int left = 0, right = nums.length - 1, mid; // pointers for binary search approach

        while (left <= right) {
            mid = left + (right - left) / 2; // calculate mid

            if (target == nums[mid]) { // if we found the target at mid, just return the mid
                return mid;
            }
            else if (nums[left] <= nums[mid]) { // if the left pointer element is less than or same as the mid pointer element, meaning you are in the left sorted part
                if (target > nums[mid] || target < nums[left]) { // if the target is greater than the mid element or if its less than the left element, it means its in the right sorted part
                    left = mid + 1; // increment left accordingly
                }
                else { // otherwise decrement right
                    right = mid - 1;
                }
            }
            else { // only outcome left is you are at the right sorted part
                if (target < nums[mid] || target > nums[right]) { // then if the target is less than mid element or if its greater than the right element, it means its in the left sorted part
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
        }

        return -1; // return if not found
    }
    public static void main(String[] args) {
        int[] nums = {3,4,5,6,1,2}, nums2 = {3,5,6,0,1,2};
        int target = 1, target2 = 4;

        System.out.println(search(nums, target));
        System.out.println(search(nums2, target2));

        // time complexity of this is O(log(n)) due to binary search and the space complexity is O(1)
    }
}