public class median_of_two_sorted_arrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*
        Brute force approach O(m + n) time and space complexity

        ArrayList<Integer> nums3 = new ArrayList<>();

        for (int num : nums1) {
            nums3.add(num);
        }
        for (int num : nums2) {
            nums3.add(num);
        }

        Collections.sort(nums3);

        int size = nums3.size();
        double median = 0;

        if (size % 2 == 0) {
            median = (nums3.get(size/2 - 1) + nums3.get(size/2)) / 2.0;
        } else {
            median = nums3.get(size/2);
        }

        return median;
        */

        if (nums1.length > nums2.length) { // to ensure that nums1 is smaller array we swap them if it is not
            return findMedianSortedArrays(nums2, nums1);
        }
        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = x; // high is set to x because we are doing binary search on smaller array 

        while (low <= high) {
            int partitionX = (low + high)/2; // partitionX is the number of elements on left side of partition
            int partitionY = (x + y + 1)/2 - partitionX; // partitionY is the number of elements on left side of partition

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1]; // if partitionX is 0 then there is nothing on left side. Use -INF for maxLeftX
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX]; // if partitionX is length of array then there is nothing on right side. Use +INF for minRightX

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1]; // if partitionY is 0 then there is nothing on left side. Use -INF for maxLeftY
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY]; // if partitionY is length of array then there is nothing on right side. Use +INF for minRightY

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) { // we have found the correct partition
                if ((x + y) % 2 == 0) { // if total length is even then we take average of middle two elements
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else { // if total length is odd then we take the middle element
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { // we are too far on right side for partitionX, go on left side
                high = partitionX - 1;
            } else { // we are too far on left side for partitionX, go on right side
                low = partitionX + 1;
            }
        }

        return 0; // as long as arrays are sorted, this should never be reached
    }
    public static void main(String[] args) {
        int[] nums1 = {1,2}, nums2 = {3};
        int[] nums3 = {1,3}, nums4 = {2,4};

        System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(findMedianSortedArrays(nums3, nums4));

        // time complexity is O(log(min(m, n))) and space complexity is O(1)
    }
}