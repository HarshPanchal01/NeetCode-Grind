import java.util.Stack;

public class largest_rectangle_in_histogram {
    public static int largestRectangleArea(int[] heights) {
        /*
        Brute Force O(n^3) approach

        int largest_area = 0, height = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            height = heights[i];
            stack.push(height);
            int j = i + 1;
            while (j < heights.length && heights[i] <= heights[j]) {
                stack.push(heights[j]);
                j++;
            }
            int k = i - 1;
            while (k >= 0 && heights[i] <= heights[k]) {
                stack.push(heights[k]);
                k--;
            }

            largest_area = Math.max(largest_area, stack.size() * height);
            stack.clear();
        }
        return largest_area;
        */
	    int largest_area = 0;
	    Stack<Integer> stack = new Stack<>(); // Stack to store the indices of bars

        // Traverse each bar in the histogram
        for (int i = 0; i <= heights.length; i++) {
            // Set height to 0 if we're at the end, ensuring remaining bars are processed
            int currentHeight = (i == heights.length) ? 0 : heights[i];
            // Keep removing bars from stack while the current bar is less than the bar at the stack's top
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                // Pop the top index, which represents the height of the rectangle we’re processing
                int height = heights[stack.pop()];

                // Calculate the width:
                // If the stack is empty after popping, it means height extends to the start of the array (left boundary is 0).
                // Otherwise, width is the distance between the current index and the index on the top of the stack after popping.
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                // Calculate the area with the popped height as the smallest bar and update largestArea
                largest_area = Math.max(largest_area, height * width);
            }
            // Push the current index onto the stack
            stack.push(i);
        }

        return largest_area;
    }
    public static void main(String[] args) {
        int[] heights = {7,1,7,2,2,4}, heights2 = {2,3};

        System.out.println(largestRectangleArea(heights));
        System.out.println(largestRectangleArea(heights2));
	
	    // time and space complexity will be O(n) as we loop through array and have stack of size n
    }
}
