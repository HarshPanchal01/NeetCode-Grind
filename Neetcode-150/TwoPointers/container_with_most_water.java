public class container_with_most_water {
    public static int maxArea(int[] heights) {
        /*
        Brute Force O(n^2)

        int length = 0, width = 0, max_area = 0;

        for (int i = 0; i < heights.length - 1; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                length = Math.min(heights[i], heights[j]);
                width = j - i;
                max_area = Math.max(max_area, length * width);
            }
        }

        return max_area;
        */
        int length = 0, width = 0, max_area = 0, left = 0, right = heights.length - 1; // variables for the two pointers, the max area, and the length and width

        while (left < right) { // apply the two-pointer approach and loop until the left pointer is equal to right pointer
            length = Math.min(heights[left], heights[right]); // get the length of the container which will have to be the minimum otherwise water will overflow
            width = right - left; // get the width of the container which is simply the distance between the pointers
            max_area = Math.max(max_area, length * width); // calculate the area using formula length times width and only update max area if its greater than it

            if (heights[left] <= heights[right]) { // if the length of left pointer was smaller than move left pointer to try to find greater length for max area
                left++;
            }
            else { // otherwise opposite applies and move right pointer
                right--;
            }
        }

        return max_area;
    }
    public static void main(String[] args) {
        int[] heights = {1,7,2,5,4,7,3,6}, heights2 = {2,2,2};

        System.out.println(maxArea(heights));
        System.out.println(maxArea(heights2));

        // time complexity of this would be O(n/2) because of two-pointers but it simplifies to O(n) and the space complexity is O(1)
    }
}
