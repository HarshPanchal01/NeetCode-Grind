public class binary_search {
    public static int search(int[] nums, int target) {
        int mid = 0, left = 0, right = nums.length - 1; // left and right pointers with mid pointer to implement binary search

        while (left <= right) { // applying binary search so as long as left and right dont cross each other
            mid = (left + right) / 2; // get the mid which is the floor value of (left + right) / 2, since in java integers are already rounded down if decimal we dont need floor

            if (nums[mid] == target) { // if the element at mid is the target return the mid
                return mid;
            }
            else if (nums[mid] < target) { // otherwise if the element at mid is less than the target it means target is on the right of mid so we shift left pointer there
                left = mid + 1;
            }
            else { // otherwise its the opposite and it means the target is on the left side of mid so we shift right end-point there
                right = mid - 1;
            } 
        }

        return -1; // if mid was not returned in while loop, it means target was not found
    }
    public static void main(String[] args) {
        int[] nums = {-1,0,2,4,6,8,9};
        int target = 4, target2 = 2;

        System.out.println(search(nums, target));
        System.out.println(search(nums, target2));

        // time complexity of this is O(log(n)) as we divide by 2 each iteration, and the space complexity is O(1)
    }
}
