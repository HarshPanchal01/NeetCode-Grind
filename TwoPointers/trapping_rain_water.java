public class trapping_rain_water {
    public static int trap(int[] heights) {
        /*
        Brute Force O(n^2)

        int max_area = 0, left_max = 0, right_max = 0;

        for (int i = 0; i < heights.length; i++) {
            left_max = heights[i]; 
            right_max = heights[i];

            for (int j = 0; j < i; j++) {
                left_max = Math.max(left_max, heights[j]);
            }
            for (int k = i + 1; k < heights.length; k++) {
                right_max = Math.max(right_max, heights[k]);
            }

            max_area += Math.min(left_max, right_max) - heights[i];
        }

        return max_area;
        */
        int max_area = 0, left = 0, right = heights.length - 1; // variables for our pointers and total area
        int max_left = heights[left], max_right = heights[right]; // variables to update the max left and max right height values

        while (left < right) { // use two-pointer approach to go through the array
            if (max_left <= max_right) { // if the max left height is less than the max right height we can increment it
                left++;
                max_left = Math.max(max_left, heights[left]); // update the max left height
                max_area += max_left - heights[left]; // update area with max - current height
            }
            else { // opposite of above so when the max right height is less than the max left height we can decrement it
                right--;
                max_right = Math.max(max_right, heights[right]); // update the max right height
                max_area += max_right - heights[right]; // update area with max - current height
            }
        }

        return max_area;
    }
    public static void main(String[] args) {
        int[] heights = {0,2,0,3,1,0,1,3,2,1};

        System.out.println(trap(heights));

        // time complexity of this is O(n) as we go through the array once and the space complexity is O(1)
    }
}
